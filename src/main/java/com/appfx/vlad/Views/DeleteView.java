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
public class DeleteView {

    private static Stage deleteStage;
    private static Parent deleteWindow;
    private final static Logger logger = Logger.getLogger(DeleteView.class);

    public void displayDeleteView() {
        try {
            deleteWindow = FXMLLoader.load(getClass().getResource("/deleteView.fxml"));
            deleteStage = new Stage();
            deleteStage.setTitle("Delete toy");
            deleteStage.setScene(new Scene(deleteWindow));
            deleteStage.initModality(Modality.APPLICATION_MODAL);
            deleteStage.setResizable(false);
            deleteStage.showAndWait();
            logger.info("Delete view was successfully loaded and configurated.");
        } catch (IOException e) {
            logger.error("FXML file \"deleteView.fxml\" did not find!");
        }

    }

    public Stage getDeleteStage() {
        return deleteStage;
    }
}
