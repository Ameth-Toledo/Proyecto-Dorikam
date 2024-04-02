package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.models.Venta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class VerEntregadosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button verReportes;

    @FXML
    private TableView<Venta> TableProductosEntregados;

    @FXML
    private TableColumn<Venta, String> NombreColumn;

    @FXML
    private TableColumn<Venta, Integer> CantidadColumn;

    @FXML
    private TableColumn<Venta, String> UbicacionColumn;

    @FXML
    private TableColumn<Venta, String> FechaColumn;

    @FXML
    private Button DescargarButton;

    @FXML
    void OnMouseClickedDescargarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {
        mostrarEntregados();
    }

    @FXML
    void initialize() {
        NombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProductoProperty());
        CantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        UbicacionColumn.setCellValueFactory(cellData -> cellData.getValue().lugarEntregaProperty());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaCompraProperty());
    }
    private void mostrarEntregados() {
        TableProductosEntregados.setItems(FXCollections.observableList(Venta.getListaVentas()));
    }
}
