package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class EliminarProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'Eliminar-producto-view.fxml'.";

    }

}