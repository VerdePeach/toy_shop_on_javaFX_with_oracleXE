package com.appfx.vlad.services;

import com.appfx.vlad.models.Toy;

import java.sql.SQLException;
import java.util.List;

public interface ToyService {
    void createToy(Toy toy) throws SQLException;
    void deleteToy(Toy toy) throws SQLException;
    void editToy(Toy toy) throws SQLException;
    List<Toy> getToys() throws SQLException;
    List<Toy> getToysForAge(int startAge, int endAge) throws SQLException;
    List<Toy> getMostExpensiveToy() throws SQLException;
    List<Toy> getToysByPriseAndAge(float price, int startAge, int endAge) throws SQLException;
}
