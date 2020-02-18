package com.appfx.vlad.controllers;

import com.appfx.vlad.models.Toy;
import com.appfx.vlad.models.toyUtils.ToyUtil;
import com.appfx.vlad.services.ToyService;
import com.appfx.vlad.services.servicesImpl.ToyServiceImpl;
import com.appfx.vlad.views.GetByAgeAndPriceView;
import com.appfx.vlad.views.InfoModalView;
import com.appfx.vlad.views.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Class controller of  GetByAgeAndPriceView window.
 */
public class GetByAgeAndPriceViewController {

    private final static Logger logger = Logger.getLogger(GetByAgeAndPriceViewController.class);
    private static GetByAgeAndPriceView getByAgeAndPrice = new GetByAgeAndPriceView();
    private MainView mainView = new MainView();
    private static ToyService toyService = new ToyServiceImpl();
    private static InfoModalView infoModalView = new InfoModalView();

    @FXML
    private Button showToyByAgeAndPriceButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField startAgeTextField;

    @FXML
    private TextField endAgeTextField;

    @FXML
    private TextField priceTextField;

    /**
     * Method of start initialisation of GetByAgeAndPriceView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        cancelButton.setOnAction(e -> {
            mainView.setList(null);
            getByAgeAndPrice.getGetByAgeAndPriceStage().close();
        });
        showToyByAgeAndPriceButton.setOnAction(e -> {

            try {
                ToyUtil toyUtil = new ToyUtil();

                float price = toyUtil.checkAndGetPrice(priceTextField.getText());
                int startAge = toyUtil.checkAndGetSAge(startAgeTextField.getText());
                int endAge = toyUtil.checkAndGetEAge(endAgeTextField.getText());
                if((startAge == -1 || endAge == -1) || startAge > endAge) {
                    logger.error("Star age is > end age or (start age or end age is incorrect) startAge = "
                            + startAge + " endAge = " + endAge);
                    throw new Exception();
                }

                List<Toy> toyListStep = toyService.getToysByPriseAndAge(price, startAge, endAge);
                ObservableList<Toy> toyList = FXCollections.observableArrayList(toyListStep);
                mainView.setList(toyList);
                getByAgeAndPrice.getGetByAgeAndPriceStage().close();
                logger.info("List of toys was successfully got.");
            } catch (Exception ex) {
                infoModalView.setText("Incorrect values!");
                infoModalView.displayInfoModalView();
                logger.error("Incorrect values of age!" + ex.getMessage());
            }
        });
    }
}

