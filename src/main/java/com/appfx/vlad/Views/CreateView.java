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
public class CreateView {

    private static Stage createStage;
    private static Parent createWindow;
    private final static Logger logger = Logger.getLogger(CreateView.class);

    public void displayCreateView() {
        try {
            createWindow = FXMLLoader.load(getClass().getResource("/createView.fxml"));
            createStage = new Stage();
            createStage.setTitle("Create toy");
            createStage.setScene(new Scene(createWindow));
            createStage.initModality(Modality.APPLICATION_MODAL);
            createStage.setResizable(false);
            createStage.showAndWait();
            logger.info("Create view was successfully loaded and configurated.");
        } catch (IOException e) {
            logger.error("FXML file \"createView.fxml\" did not find!");
            e.printStackTrace();
        }
    }

    public Stage getCreateStage() {
        return createStage;
    }
}
