package com.appfx.vlad.controllers;

import com.appfx.vlad.Views.DeleteView;
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
 * Class controller of DeleteView window.
 */
public class DeleteViewController {

    private static final Logger logger = Logger.getLogger(DeleteViewController.class);
    private static DeleteView deleteView = new DeleteView();
    private static ToyService toyService = new ToyServiceImpl();
    private static InfoModalView infoModalView = new InfoModalView();
    private MainView mainView = new MainView();

    @FXML
    private Button deleteToyButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField toyNameTextField;

    @FXML
    private CheckBox checkBoxClearFields;

    @FXML
    private TextField toyIdTextField;

    /**
     * Method of start initialisation of DeleteView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        cancelButton.setOnAction(e ->
                deleteView.getDeleteStage().close()
        );

        deleteToyButton.setOnAction(e -> {

            boolean clearFields = true;
            Toy toy;
            int id;
            String name;
            try {

                ToyUtil toyUtil = new ToyUtil();
                id = toyUtil.checkAndGetId(toyIdTextField.getText());
                name = toyNameTextField.getText();
                toy = new Toy();
                toy.setId(id);
                toy.setName(name);
                try {
                    toyService.deleteToy(toy);
                    infoModalView.setText("Toy successfully deleted");
                    infoModalView.displayInfoModalView();
                    logger.info("Toy successfully deleted from database.");
                } catch (SQLException ex) {
                    infoModalView.setText("deleting ERROR!");
                    infoModalView.displayInfoModalView();
                    logger.error("Error deleting of toy incorrect values of toy properties id = " + toy.getId()
                            + " name = " + toy.getName() + "/nor toy with such name does not exist!" + ex.getMessage());
                }
            } catch (Exception ex) {
                infoModalView.setText("Data is incorrect!");
                infoModalView.displayInfoModalView();
                System.out.println("Incorrect data from user " + ex.getMessage());
                clearFields = false;
                logger.error("Error deleting of toy incorrect values of toy properties" + ex.getMessage());
            }

            if(checkBoxClearFields.isSelected() && clearFields) {
                toyNameTextField.clear();
                toyIdTextField.clear();
            }
        });
    }
}
