package com.appfx.vlad.services.servicesImpl;

import com.appfx.vlad.dao.ToyDAO;
import com.appfx.vlad.dao.daoImpl.ToyDAOImpl;
import com.appfx.vlad.models.Toy;
import com.appfx.vlad.services.ToyService;

import java.sql.SQLException;
import java.util.List;

public class ToyServiceImpl implements ToyService {

    private static ToyDAO toyDAO = new ToyDAOImpl();

    @Override
    public void createToy(Toy toy) throws SQLException {
        toyDAO.insertToy(toy);
    }

    @Override
    public void deleteToy(Toy toy) throws SQLException {
        toyDAO.deleteToy(toy);
    }

    @Override
    public void editToy(Toy toy) throws SQLException {
        toyDAO.updateToy(toy);
    }

    @Override
    public List<Toy> getToys() throws SQLException {
        return toyDAO.getToys();
    }

    @Override
    public List<Toy> getToysForAge(int startAge, int endAge) throws SQLException {
        return toyDAO.getToysForAge(startAge, endAge);
    }

    @Override
    public List<Toy> getMostExpensiveToy() throws SQLException  {
        return toyDAO.getMostExpensiveToy();
    }

    @Override
    public List<Toy> getToysByPriseAndAge(float price, int startAge, int endAge) throws SQLException {
        return toyDAO.getToysByPriseAndAge(price, startAge, endAge);
    }
}
