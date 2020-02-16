package com.appfx.vlad.controllers;

import com.appfx.vlad.Views.EditView;
import com.appfx.vlad.Views.InfoModalView;
import com.appfx.vlad.Views.MainView;
import com.appfx.vlad.models.Toy;
import com.appfx.vlad.models.toyUtils.ToyUtil;
import com.appfx.vlad.services.ToyService;
import com.appfx.vlad.services.servicesImpl.ToyServiceImpl;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Class controller of EditView window.
 */
public class EditViewController {

    private static final Logger logger = Logger.getLogger(EditViewController.class);
    private static EditView editView = new EditView();
    private static ToyService toyService = new ToyServiceImpl();
    private static InfoModalView infoModalView = new InfoModalView();
    private static MainView mainView = new MainView();

    @FXML
    private Button editToyButton;

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

    @FXML
    private TextField toyIdTextField;

    /**
     * Method of start initialisation of EditView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        cancelButton.setOnAction(e -> editView.getCreateStage().close());
        editToyButton.setOnAction(e -> {

            boolean clearFields = true;

            Toy toy = null;
            String name;
            float price;
            int amount;
            int sAge;
            int eAge;
            int id;

            try {
                name = toyNameTextField.getText();

                ToyUtil toyUtil = new ToyUtil();
                id = toyUtil.checkAndGetId(toyIdTextField.getText());
                amount = toyUtil.checkAndGetAmount(toyAmountTextField.getText());
                price = toyUtil.checkAndGetPrice(toyPriceTextField.getText());
                sAge = toyUtil.checkAndGetSAge(toyStartAgeTextField.getText());
                eAge = toyUtil.checkAndGetEAge(toyEndAgeTextField.getText());

                toy = new Toy(id, name, price, amount, sAge, eAge);
                try {
                    toyService.editToy(toy);
                    infoModalView.setText("Toy was successfully edited.");
                    infoModalView.displayInfoModalView();
                    logger.info("Toy was successfully edited in database.");
                } catch (SQLException ex) {
                    infoModalView.setText("Editing error! Incorrect data!");
                    infoModalView.displayInfoModalView();
                    logger.error("Error editing of toy incorrect values of toy properties " + toy.toString()
                            + "/nor toy with such name ot id does not exist!" + ex.getMessage());
                    clearFields = false;
                }
            } catch (Exception ex) {
                infoModalView.setText("Data is incorrect!");
                infoModalView.displayInfoModalView();
                clearFields = false;
                logger.error("Error editing of toy incorrect values of toy properties " + toy.toString() + ex.getMessage());
            }

            if (checkBoxClearFields.isSelected() && clearFields){
                toyIdTextField.clear();
                toyNameTextField.clear();
                toyPriceTextField.clear();
                toyAmountTextField.clear();
                toyStartAgeTextField.clear();
                toyEndAgeTextField.clear();
            }
        });
    }

}

