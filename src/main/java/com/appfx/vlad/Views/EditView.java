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
public class EditView {

    private static Stage editStage;
    private static Parent editWindow;
    private final static Logger logger = Logger.getLogger(EditView.class);

    public void displayEditView() {
        try {
            editWindow = FXMLLoader.load(getClass().getResource("/editView.fxml"));
            editStage = new Stage();
            editStage.setTitle("Edit toy");
            editStage.setScene(new Scene(editWindow));
            editStage.initModality(Modality.APPLICATION_MODAL);
            editStage.setResizable(false);
            editStage.showAndWait();
            logger.info("Edit view was successfully loaded and configurated.");
        } catch (IOException e) {
            logger.error("FXML file \"editView.fxml\" did not find.");
        }
    }

    public Stage getCreateStage() {
        return editStage;
    }
}

