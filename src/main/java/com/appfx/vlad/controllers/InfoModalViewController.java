package com.appfx.vlad.controllers;

import com.appfx.vlad.views.InfoModalView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Class controller of InfoModalView window.
 */
public class InfoModalViewController {

    private static InfoModalView infoModalView;

    @FXML
    private Button InfoButtonOK;

    @FXML
    private Label InfoLabel;

    /**
     * Method of start initialisation of ModalView window nodes.
     * Here described event listeners of the window buttons
     * and interactions settings of window.
     */
    @FXML
    private void initialize() {
        InfoButtonOK.setOnAction(e -> InfoModalView.getInfoModalStage().close());
        InfoLabel.setText(InfoModalView.getText());
    }

}


