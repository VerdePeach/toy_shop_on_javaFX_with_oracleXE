package com.appfx.vlad.controllers;

import com.appfx.vlad.models.Toy;
import com.appfx.vlad.services.ToyService;
import com.appfx.vlad.services.servicesImpl.ToyServiceImpl;
import com.appfx.vlad.views.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Class controller of MainView window.
 */
public class MainViewController {

    private final static Logger logger = Logger.getLogger(MainViewController.class);
    private static CreateView createView = new CreateView();
    private static EditView editView = new EditView();
    private static DeleteView deleteView = new DeleteView();
    private static GetByAgeView getByAgeView = new GetByAgeView();
    private static GetByAgeAndPriceView getByAgeAndPrice = new GetByAgeAndPriceView();
    private static InfoModalView infoModalView = new InfoModalView();
    private MainView mainView = new MainView();
    private static ToyService toyService = new ToyServiceImpl();

    /**
     * Method gives createView object.
     *
     * @return createView object.
     */
    static CreateView getCreateStage() {
        return createView;
    }

    @FXML
    private MenuItem exitMenuItem;

    @FXML
    private MenuItem helpMenuItem;

    @FXML
    private Button createButton;

    @FXML
    private Button editButton;

    @FXML
    private Button deleteButton;

    @FXML
    private Button getAllButton;

    @FXML
    private Button getByAgeButton;

    @FXML
    private Button getMostExpensiveButton;

    @FXML
    private Button getByPriceAndAgeButton;

    @FXML
    private TableView<Toy> toyTable;

    @FXML
    private TableColumn<Toy, Integer> toyIdColumn;

    @FXML
    private TableColumn<Toy, String> toyNameColumn;

    @FXML
    private TableColumn<Toy, Float> priceColumn;

    @FXML
    private TableColumn<Toy, Integer> amountColumn;

    @FXML
    private TableColumn<Toy, Integer> startAgeColumn;

    @FXML
    private TableColumn<Toy, Integer> endAgeColumn;

    /**
     * Method of start initialisation of MainView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        toyIdColumn.setCellValueFactory(cellData -> cellData.getValue().getId().asObject());
        toyNameColumn.setCellValueFactory(cellData -> cellData.getValue().getName());
        priceColumn.setCellValueFactory(cellData -> cellData.getValue().getPrice().asObject());
        amountColumn.setCellValueFactory(cellData -> cellData.getValue().getAmount().asObject());
        startAgeColumn.setCellValueFactory(cellData -> cellData.getValue().getStartAge().asObject());
        endAgeColumn.setCellValueFactory(cellData -> cellData.getValue().getEndAge().asObject());

        createButton.setOnAction(e -> {
            createView.displayCreateView();
            getToyObservableList();
        });

        editButton.setOnAction(e -> {
            editView.displayEditView();
            getToyObservableList();
        });

        deleteButton.setOnAction(e -> {
            deleteView.displayDeleteView();
            getToyObservableList();
        });

        getAllButton.setOnAction(e -> getToyObservableList());

        getByAgeButton.setOnAction(e -> {
            getByAgeView.displayGetByAgeView();
            ObservableList<Toy> toyList = mainView.getList();
            if (toyList != null) {
                if (toyList.size() != 0) {
                    toyTable.setItems(toyList);
                } else {
                    infoModalView.setText("Toys with such parameters was not found!");
                    infoModalView.displayInfoModalView();
                }
            }
        });

        getMostExpensiveButton.setOnAction(e -> {
            try {
                ObservableList<Toy> toyList = FXCollections.observableArrayList(toyService.getMostExpensiveToy());
                toyTable.setItems(toyList);
                logger.info("The most expansive toys were found.");
            } catch (SQLException ex) {
                logger.error("SQL error. " + ex.getMessage());
            }
        });

        getByPriceAndAgeButton.setOnAction(e -> {
            getByAgeAndPrice.displayGetByAgeAndPriceView();
            ObservableList<Toy> toyList = mainView.getList();
            if (toyList != null){
                if (toyList.size() != 0){
                    toyTable.setItems(toyList);
                } else {
                    infoModalView.setText("Toys with such parameters was not found!");
                    infoModalView.displayInfoModalView();
                }
            }
        });

        exitMenuItem.setOnAction(e -> mainView.getMainStage().close());

        helpMenuItem.setOnAction(e -> {
            try {
                Desktop.getDesktop().open(new File("target/classes/help.html"));
            } catch (IOException ex) {
                logger.error("File was not found" + ex.getMessage());
            }
        });

        getToyObservableList();
    }

    /**
     * Method gives full toy list.
     *
     * @return full toy list from base.
     */
    private ObservableList<Toy>  getToyObservableList() {
        ObservableList<Toy> toyData = FXCollections.observableArrayList();
        try {
            toyData.setAll(toyService.getToys());
            toyTable.setItems(toyData);
            logger.info("Toys was got from database and successfully pushed to view table.");
        } catch (SQLException ex) {
            logger.error("Error of updating mainView table after adding, editing, deleting. " + ex.getMessage());
        }
        return toyData;
    }
}

