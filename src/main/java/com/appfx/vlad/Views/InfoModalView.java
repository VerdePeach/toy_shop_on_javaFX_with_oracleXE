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
public class InfoModalView {

    private static Stage infoModalStage;
    private static Parent infoModalWindow;
    private final static Logger logger = Logger.getLogger(InfoModalView.class);

    private static String text;

    public void displayInfoModalView() {
        try {
            infoModalWindow = FXMLLoader.load(getClass().getResource("/infoModalView.fxml"));
            infoModalStage = new Stage();
            infoModalStage.setTitle("Info");
            infoModalStage.setScene(new Scene(infoModalWindow));
            infoModalStage.initModality(Modality.APPLICATION_MODAL);
            infoModalStage.setResizable(false);
            infoModalStage.showAndWait();
            logger.info("Modal view was successfully loaded and configurated.");
        } catch (IOException e) {
            logger.error("FXML file \"infoModalView.fxml\" did not find.");
        }
    }

    public static Stage getInfoModalStage() {
        return infoModalStage;
    }

    public static String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
