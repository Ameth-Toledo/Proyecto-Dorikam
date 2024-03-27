package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class CancelarVenta {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CategoriaProduct;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private TextField DateProduct;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField IDProduct;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField UbicationProduct;

    @FXML
    private TextField motivo;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert CategoriaProduct != null : "fx:id=\"CategoriaProduct\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert ConfirmarButton != null : "fx:id=\"ConfirmarButton\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert DateProduct != null : "fx:id=\"DateProduct\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert IDProduct != null : "fx:id=\"IDProduct\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert NameProduct != null : "fx:id=\"NameProduct\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert UbicationProduct != null : "fx:id=\"UbicationProduct\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";
        assert motivo != null : "fx:id=\"motivo\" was not injected: check your FXML file 'cancelar-venta-view.fxml'.";

    }

}
