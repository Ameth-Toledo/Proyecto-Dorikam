package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

public class RealizarVentaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private ComboBox<?> pago;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'realizar-venta-view.fxml'.";
        assert pago != null : "fx:id=\"pago\" was not injected: check your FXML file 'realizar-venta-view.fxml'.";

    }

}
