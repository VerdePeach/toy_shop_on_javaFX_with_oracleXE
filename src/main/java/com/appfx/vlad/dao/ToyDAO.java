package com.appfx.vlad.dao;

import com.appfx.vlad.models.Toy;

import java.sql.SQLException;
import java.util.List;

/**
 * Interface of ToyDAO.
 */
public interface ToyDAO {
    /**
     * Method creates new toy to database.
     *
     * @param toy - toy that was generated of user values.
     * @throws SQLException if user values are incorrect for base or something was wrong with base or query.
     */
    void insertToy(Toy toy) throws SQLException;

    /**
     * Method deletes the toy from database.
     *
     * @param toy - toy that was generated of user values.
     * @throws SQLException if user values are incorrect for base or something was wrong with base or query.
     */
    void deleteToy(Toy toy) throws SQLException;

    /**
     * Method updates the toy from database.
     *
     * @param toy - toy that was generated of user values.
     * @throws SQLException if user values are incorrect for base or something was wrong with base or query.
     */
    void updateToy(Toy toy) throws SQLException;

    /**
     * Method gives the full toy list from database.
     *
     * @return full list of toys from base.
     * @throws SQLException if something was wrong with base of query.
     */
    List<Toy> getToys() throws SQLException;

    /**
     * Method gives the toy list in specified age diapason.
     * @param startAge - start age when child can start play with the toy.
     * @param endAge - end age when child is adult to play with the toy.
     * @return list of the toys in specified age diapason.
     * @throws SQLException if user values are incorrect for base or something was wrong with base or query.
     */
    List<Toy> getToysForAge(int startAge, int endAge) throws SQLException;

    /**
     * Method gives the most expansive toys.
     * @return list of the toys with the highest price.
     * @throws SQLException - something was wrong with base or query.
     */
    List<Toy> getMostExpensiveToy() throws SQLException;

    /**
     * Method gives the toy list in specified age diapason and specified price.
     * @param price - price of the toys that should be included to return list.
     * @param startAge - start age when child can start play with the toy.
     * @param endAge - end age when child is adult to play with the toy.
     * @return list of the toys in specified age diapason and specified price.
     * @throws SQLException if user values are incorrect for base or something was wrong with base or query.
     */
    List<Toy> getToysByPriseAndAge(float price, int startAge, int endAge) throws SQLException;
}
