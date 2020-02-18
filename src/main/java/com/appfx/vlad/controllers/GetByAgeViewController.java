package com.appfx.vlad.controllers;

import com.appfx.vlad.models.Toy;
import com.appfx.vlad.models.toyUtils.ToyUtil;
import com.appfx.vlad.services.ToyService;
import com.appfx.vlad.services.servicesImpl.ToyServiceImpl;
import com.appfx.vlad.views.GetByAgeView;
import com.appfx.vlad.views.InfoModalView;
import com.appfx.vlad.views.MainView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import org.apache.log4j.Logger;

import java.sql.SQLException;

/**
 * Class controller of GetByAgeView window.
 */
public class GetByAgeViewController {

    private final static Logger logger = Logger.getLogger(GetByAgeViewController.class);
    private static GetByAgeView getByAgeView = new GetByAgeView();
    private static MainView mainView = new MainView();
    private static ToyService toyService = new ToyServiceImpl();
    private static InfoModalView infoModalView = new InfoModalView();

    @FXML
    private Button showToyByAgeButton;

    @FXML
    private Button cancelButton;

    @FXML
    private TextField endAgeTextField;

    @FXML
    private TextField startAgeTextField;

    /**
     * Method of start initialisation of GetByAgeView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        cancelButton.setOnAction(e -> {
            mainView.setList(null);
            getByAgeView.getGetByAgeStage().close();
        });

        showToyByAgeButton.setOnAction(e -> {
            try {
                ToyUtil toyUtil = new ToyUtil();

                int startAge = toyUtil.checkAndGetSAge(startAgeTextField.getText());
                int endAge = toyUtil.checkAndGetEAge(endAgeTextField.getText());
                if ((startAge == -1 || endAge == -1) || startAge > endAge) {
                    logger.error("Star age is > end age or (start age or end age is incorrect) startAge = "
                            + startAge + " endAge = " + endAge);
                    throw new NumberFormatException();
                }
                ObservableList<Toy> toyList = FXCollections.observableArrayList(toyService.getToysForAge(startAge, endAge));
                mainView.setList(toyList);
                getByAgeView.getGetByAgeStage().close();
                logger.info("List of toys was successfully got.");
            } catch (NumberFormatException ex) {
                infoModalView.setText("Incorrect values of age!");
                infoModalView.displayInfoModalView();
                logger.error("Incorrect values of age" + ex.getMessage());
            } catch (SQLException ex) {
                infoModalView.setText("Incorrect values!");
                infoModalView.displayInfoModalView();
                logger.error("Incorrect values. " + ex.getMessage());
            }
        });
    }

}
