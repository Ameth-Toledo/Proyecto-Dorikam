package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GerenteButton;

    @FXML
    private Button AdministradorButton;

    @FXML
    void OnMouseClickedAdministradorButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedGerenteButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert GerenteButton != null : "fx:id=\"GerenteButton\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert AdministradorButton != null : "fx:id=\"AdministradorButton\" was not injected: check your FXML file 'hello-view.fxml'.";

    }

public void init(Stage stageRoot) {
    }
}