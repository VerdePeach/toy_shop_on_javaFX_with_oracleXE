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
public class GetByAgeAndPriceView {
    private static Stage getByAgeAndPriceStage;
    private static Parent getByAgeAndPriceWindow;
    private final static Logger logger = Logger.getLogger(GetByAgeAndPriceView.class);

    public void displayGetByAgeAndPriceView() {
        try {
            getByAgeAndPriceWindow = FXMLLoader.load(getClass().getResource("/getByAgeAndPriceView.fxml"));
            getByAgeAndPriceStage = new Stage();
            getByAgeAndPriceStage.setTitle("Get toy by age and price");
            getByAgeAndPriceStage.setScene(new Scene(getByAgeAndPriceWindow));
            getByAgeAndPriceStage.initModality(Modality.APPLICATION_MODAL);
            getByAgeAndPriceStage.setResizable(false);
            getByAgeAndPriceStage.showAndWait();
            logger.info("View - \"Get by age and price\" was successfully loaded and configurated.");
        } catch (IOException e) {
            logger.error("FXML file \"getByAgeAndPriceView.fxml\" did not find.");
        }
    }

    public Stage getGetByAgeAndPriceStage() {
        return getByAgeAndPriceStage;
    }
}
