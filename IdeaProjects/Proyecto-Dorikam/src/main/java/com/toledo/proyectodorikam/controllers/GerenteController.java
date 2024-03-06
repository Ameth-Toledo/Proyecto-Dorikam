package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GerenteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EntrarButton;

    @FXML
    private Button ExitButton;


    @FXML
    void OnMouseClickedEntrarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert EntrarButton != null : "fx:id=\"EntrarButton\" was not injected: check your FXML file 'gerente-view.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'gerente-view.fxml'.";

    }
}
