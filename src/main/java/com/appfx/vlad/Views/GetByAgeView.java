package com.appfx.vlad.Views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * @author VerdePeach
 */
public class GetByAgeView {

    private static Stage getByAgeStage;
    private static Parent getByAgeWindow;
    private final static Logger logger = Logger.getLogger(GetByAgeView.class);

    public void displayGetByAgeView() {
        try {
            getByAgeWindow = FXMLLoader.load(getClass().getResource("/getByAgeView.fxml"));
            getByAgeStage = new Stage();
            getByAgeStage.setTitle("Get toy by age");
            getByAgeStage.setScene(new Scene(getByAgeWindow));
            getByAgeStage.initModality(Modality.APPLICATION_MODAL);
            getByAgeStage.setResizable(false);
            getByAgeStage.showAndWait();
            logger.info("View - \"Get by age\" was successfully loaded and configurated.");
        } catch (IOException e) {
            logger.error("FXML file \"getByAgeView.fxml\" did not find!");
        }
    }

    public Stage getGetByAgeStage () {
        return getByAgeStage;
    }
}
