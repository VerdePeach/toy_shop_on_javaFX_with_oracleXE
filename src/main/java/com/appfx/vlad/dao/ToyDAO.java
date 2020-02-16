package com.appfx.vlad.dao;

import com.appfx.vlad.models.Toy;

import java.sql.SQLException;
import java.util.List;

public interface ToyDAO {
    void insertToy(Toy toy) throws SQLException;
    void deleteToy(Toy toy) throws SQLException;
    void updateToy(Toy toy) throws SQLException;
    List<Toy> getToys() throws SQLException;
    List<Toy> getToysForAge(int startAge, int endAge) throws SQLException;
    List<Toy> getMostExpensiveToy() throws SQLException;
    List<Toy> getToysByPriseAndAge(float price, int startAge, int endAge) throws SQLException;
}
