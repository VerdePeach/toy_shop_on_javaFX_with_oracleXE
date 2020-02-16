package com.appfx.vlad.controllers;

import com.appfx.vlad.Views.InfoModalView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class InfoModalViewController {

    private static InfoModalView infoModalView;

    @FXML
    private Button InfoButtonOK;

    @FXML
    private Label InfoLabel;

    @FXML
    private void initialize() {
        InfoButtonOK.setOnAction(e -> infoModalView.getInfoModalStage().close());
        InfoLabel.setText(infoModalView.getText());
    }

}


