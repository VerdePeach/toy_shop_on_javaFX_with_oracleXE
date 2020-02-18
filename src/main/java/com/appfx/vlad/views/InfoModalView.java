package com.appfx.vlad.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Class of modal window
 * that informs user about warnings and successes.
 * @author VerdePeach
 */
public class InfoModalView {

    private static Stage infoModalStage;
    private static Parent infoModalWindow;
    private final static Logger logger = Logger.getLogger(InfoModalView.class);

    private static String text;

    /**
     * Method that loads and sets Stage for modal window.
     */
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

    /**
     * Method gives stage of modal window.
     *
     * @return stage of modal window.
     */
    public static Stage getInfoModalStage() {
        return infoModalStage;
    }

    /**
     * Method gives the text of modal window.
     *
     * @return text of modal window.
     */
    public static String getText() {
        return text;
    }

    /**
     * Method that sets the text of modal window.
     *
     * @param text - text of modal window.
     */
    public void setText(String text) {
        InfoModalView.text = text;
    }
}
