package com.appfx.vlad.Views;

import com.appfx.vlad.models.Toy;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Main class and mainView
 * for loading main stage
 * and saving information about List of toys.
 *
 * @author VerdePeach
 * @version 1.0
 */
public class MainView extends Application {

    private static ObservableList<Toy> toyData = FXCollections.observableArrayList();
    private static Stage mainStage = null;
    private final static Logger logger = Logger.getLogger(MainView.class);

    /**
     * Main method of the programme.
     * @param args - start arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Method for load Stage of main view.
     * @param primaryStage - stage of main view.
     */
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/mainView.fxml"));
            primaryStage.setTitle("Toy Shop");
            primaryStage.setScene(new Scene(root));
            primaryStage.show();
            mainStage = primaryStage;
            logger.info("Main view was successfully loaded and configurated.");
        } catch (IOException ex) {
            logger.error("FXML file \"mainView.fxml\" did not find.");
        }

    }

    /**
     * Method for getting List of toys.
     * @return List of toys.
     */
    public ObservableList<Toy> getList() {
        return toyData;
    }

    /**
     * Method for setting List of toys.
     * @param toyList - List of toys.
     */
    public void setList(ObservableList<Toy> toyList) {
        toyData = toyList;
    }

    /**
     * Method that gets the stage of main view.
     * @return - main stage of main view.
     */
    public Stage getMainStage() {
        return mainStage;
    }
}
