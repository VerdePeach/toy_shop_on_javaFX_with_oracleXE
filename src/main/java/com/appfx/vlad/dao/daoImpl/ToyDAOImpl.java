package com.appfx.vlad.dao.daoImpl;

import com.appfx.vlad.dao.ToyDAO;
import com.appfx.vlad.dao.dbLogic.Util;
import com.appfx.vlad.models.Toy;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;

/**
 * Class that realise ToyDAO.
 * Includes logic of working with database.
 */
public class ToyDAOImpl implements ToyDAO {

    private final static Logger logger = Logger.getLogger(ToyDAOImpl.class);
    private Connection conn = null;
    private PreparedStatement preparedStatement = null;
    private String sql;

    @Override
    public void insertToy(Toy toy) throws SQLException {
        conn = Util.connection();
        sql = "INSERT INTO toy VALUES (toy_seq.NEXTVAL, ?, ?, ?, ?, ?)";
        preparedStatement = conn.prepareStatement(sql);
        setPreparedStatement(toy, preparedStatement);

        preparedStatement.executeUpdate();
        conn.close();
        logger.info("New toy was successfully added to database.");
    }

    @Override
    public void deleteToy(Toy toy) throws SQLException {
        boolean isExistToy = existToy(toy);
        if (isExistToy) {
            conn = Util.connection();
            sql = "DELETE FROM toy WHERE t_name = ? or t_id = ?";

            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, toy.getName().get());
            preparedStatement.setInt(2, toy.getId().get());
            preparedStatement.executeUpdate();

            conn.close();
            logger.info("The toy was successfully deleted from database.");
        } else {
            logger.error("The toy with such id " + toy.getId() +  " or name " + toy.getName() + " did not exist!(editing)");
            throw new SQLException();
        }
    }

    @Override
    public void updateToy(Toy toy) throws SQLException {
        boolean isExistToy = existToy(toy);

        if (isExistToy) {
            conn = Util.connection();
            sql = "UPDATE toy SET t_name = ?, price = ?, amount = ?, s_age = ?, e_age = ? WHERE t_id = ? or t_name = ?";
            preparedStatement = conn.prepareStatement(sql);
            setPreparedStatement(toy, preparedStatement);
            preparedStatement.setInt(6, toy.getId().get());
            preparedStatement.setString(7, toy.getName().get());
            preparedStatement.executeUpdate();
            conn.close();
            logger.info("The toy was successfully edited in database.");
        } else {
            logger.error("The toy with such id  " + toy.getId() + " or name " + toy.getName() + " or name did not exist! (editing)");
            throw new SQLException();
        }
    }


    @Override
    public List<Toy> getToys() throws SQLException{
        conn = Util.connection();
        sql = "SELECT * FROM toy";
        preparedStatement = conn.prepareStatement(sql);

        return getToyListFromResultSet(preparedStatement);
    }

    @Override
    public List<Toy> getToysForAge(int startAge, int endAge) throws SQLException{
        conn = Util.connection();
        sql = "SELECT * FROM toy WHERE s_age >= ? and e_age <= ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1, startAge);
        preparedStatement.setInt(2, endAge);

        return getToyListFromResultSet(preparedStatement);
    }

    @Override
    public List<Toy> getMostExpensiveToy() throws SQLException {
        conn = Util.connection();
        sql = "SELECT * FROM toy WHERE price = (SELECT MAX(price) FROM toy)";
        preparedStatement = conn.prepareStatement(sql);

        return getToyListFromResultSet(preparedStatement);
    }

    @Override
    public List<Toy> getToysByPriseAndAge(float price, int startAge, int endAge) throws SQLException {
        conn = Util.connection();
        sql = "SELECT * FROM toy WHERE price = ? and s_age >= ? and e_age <= ?";
        preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setFloat(1, price);
        preparedStatement.setInt(2, startAge);
        preparedStatement.setInt(3, endAge);

        return getToyListFromResultSet(preparedStatement);
    }

    /**
     * Method sets preparedStatement
     *
     * @param toy               - toy with checked parameters.
     * @param preparedStatement - statement that should be configured.
     * @throws SQLException if something goes wrong with toy parameters or preparedStatement.
     */
    private void setPreparedStatement (Toy toy, PreparedStatement preparedStatement) throws SQLException {
        preparedStatement.setString(1, toy.getName().get());

        if (toy.getPrice().get() == -1) {
            preparedStatement.setNull(2, NULL);
        } else {
            preparedStatement.setFloat(2, toy.getPrice().get());
        }

        if (toy.getAmount().get() == -1) {
            preparedStatement.setNull(3, NULL);
        } else {
            preparedStatement.setInt(3, toy.getAmount().get());
        }

        if (toy.getStartAge().get() == -1) {
            preparedStatement.setNull(4, NULL);
        } else {
            preparedStatement.setInt(4, toy.getStartAge().get());
        }

        if (toy.getEndAge().get() == -1) {
            preparedStatement.setNull(5, NULL);
        } else {
            preparedStatement.setInt(5, toy.getEndAge().get());
        }
    }

    /**
     * @param preparedStatement - statement that should be executed.
     * @return toy list.
     * @throws SQLException if something goes wrong with preparedStatement, database or parameters.
     */
    private List<Toy> getToyListFromResultSet(PreparedStatement preparedStatement) throws SQLException{
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Toy> toyList = new ArrayList<>();
        while (resultSet.next()) {
            Toy toySql = new Toy();
            toySql.setId(resultSet.getInt("t_id"));
            toySql.setName(resultSet.getString("t_name"));
            toySql.setPrice(resultSet.getFloat("price"));
            toySql.setAmount(resultSet.getInt("amount"));
            toySql.setStartAge(resultSet.getInt("s_age"));
            toySql.setEndAge(resultSet.getInt("e_age"));
            toyList.add(toySql);
        }
        conn.close();
        logger.info("Toy list was got successfully.");
        return toyList;
    }

    /**
     * Method compare the user toy and toys in base.
     * If toy coincided method return true.
     *
     * @param toy - user toy.
     * @return true or false
     * @throws SQLException if something goes wrong with base or connection to base.
     */
    private boolean existToy(Toy toy) throws SQLException {
        List<Toy> toyList = getToys();
        boolean isExistToy = false;
        for(Toy t: toyList) {
            if(t.getId().getValue().intValue() == toy.getId().getValue().intValue()
                    || t.getName().getValue().equalsIgnoreCase(toy.getName().getValue())){
                isExistToy = true;
                logger.info("Toy with id " + toy.getId() + " or name " + toy.getName() + " was found");
            }
        }
        return isExistToy;
    }
}
