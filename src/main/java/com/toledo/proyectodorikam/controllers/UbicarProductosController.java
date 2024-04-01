package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class UbicarProductosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EntregasButton;

    @FXML
    private TableView<?> TableUbication;

    @FXML
    private TableColumn<?, ?> Producto;

    @FXML
    private TableColumn<?, ?> Id;

    @FXML
    private TableColumn<?, ?> Cantidad;

    @FXML
    private TableColumn<?, ?> Precio;

    @FXML
    private TableColumn<?, ?> Entrega;

    @FXML
    private TableColumn<?, ?> Stock;

    @FXML
    private Button UbicationsButton;

    @FXML
    private Button ExitButton;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void onMouseClickedEntregasButton(MouseEvent event) {

    }

    @FXML
    void onMouseClickedUbicationsButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
    }
}
