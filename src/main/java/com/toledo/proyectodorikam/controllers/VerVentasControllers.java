package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;

public class VerVentasControllers {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button VerVentasButton;

    @FXML
    private TableColumn<?, ?> IDProductoTable;

    @FXML
    private TableColumn<?, ?> NameProductoTable;

    @FXML
    private TableColumn<?, ?> DateProductoTable;

    @FXML
    private TableColumn<?, ?> CantidadProductoTable;

    @FXML
    private TableColumn<?, ?> PrecioProductoTable;

    @FXML
    private TableColumn<?, ?> TotalVendidoProductoTable;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void onMouseClickedVerVentasButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
    }
}