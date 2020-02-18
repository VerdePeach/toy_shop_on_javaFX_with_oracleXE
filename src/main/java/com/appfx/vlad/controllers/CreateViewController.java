package com.appfx.vlad.controllers;

import com.appfx.vlad.models.Toy;
import com.appfx.vlad.models.toyUtils.ToyUtil;
import com.appfx.vlad.services.servicesImpl.ToyServiceImpl;
import com.appfx.vlad.views.CreateView;
import com.appfx.vlad.views.InfoModalView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Class controller of CreateView window.
 */
public class CreateViewController {

    private final static Logger logger = Logger.getLogger(CreateViewController.class);
    private static CreateView createView = MainViewController.getCreateStage();
    private static InfoModalView infoModalView = new InfoModalView();
    private static ToyServiceImpl toyService = new ToyServiceImpl();

    @FXML
    private Button addNewToyButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField toyNameTextField;

    @FXML
    private TextField toyPriceTextField;

    @FXML
    private TextField toyAmountTextField;

    @FXML
    private TextField toyStartAgeTextField;

    @FXML
    private TextField toyEndAgeTextField;

    @FXML
    private CheckBox checkBoxClearFields;

    /**
     * Method of start initialisation of CreateView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        cancelButton.setOnAction(e -> createView.getCreateStage().close());

        addNewToyButton.setOnAction(e -> {

            boolean clearFields = true;

            Toy toy = null;
            String name;
            float price;
            int amount;
            int sAge;
            int eAge;

            try {
                name = toyNameTextField.getText();

                ToyUtil toyUtil = new ToyUtil();
                amount = toyUtil.checkAndGetAmount(toyAmountTextField.getText());
                price = toyUtil.checkAndGetPrice(toyPriceTextField.getText());
                sAge = toyUtil.checkAndGetSAge(toyStartAgeTextField.getText());
                eAge = toyUtil.checkAndGetEAge(toyEndAgeTextField.getText());

                toy = new Toy(name, price, amount, sAge, eAge);
                try {
                    toyService.createToy(toy);
                    infoModalView.setText("Toy successfully added.");
                    infoModalView.displayInfoModalView();
                    logger.info("Toy successfully added to database.");
                } catch (SQLException ex) {
                    infoModalView.setText("Name field is incorrect.\nOr toy with such name has already existed.");
                    infoModalView.displayInfoModalView();
                    logger.error("Error adding of new toy incorrect values of toy properties " + toy.toString()
                            + "/nor toy with such name has already exists!" + ex.getMessage());
                    clearFields = false;
                }
            } catch (NumberFormatException ex) {
                infoModalView.setText("Incorrect values of fields!");
                infoModalView.displayInfoModalView();
                clearFields = false;
                if (toy != null)
                    logger.error("Error adding of new toy incorrect values of toy properties " + toy.toString() + ex.getMessage());
                else
                    logger.error("Error adding of new toy incorrect values of toy is null " + ex.getMessage());
            }

            if (checkBoxClearFields.isSelected() && clearFields){
                toyNameTextField.clear();
                toyPriceTextField.clear();
                toyAmountTextField.clear();
                toyStartAgeTextField.clear();
                toyEndAgeTextField.clear();
            }
        });
    }

}


