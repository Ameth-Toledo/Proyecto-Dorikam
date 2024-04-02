package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class VerVentasController {

    @FXML
    private Button ExitButton;

    @FXML
    private Button VerVentasButton;

    @FXML
    private TableView<Venta> HistorialVentas;

    @FXML
    private TableColumn<Venta, String> NameProductoTable;

    @FXML
    private TableColumn<Venta, Double> PrecioProductoTable;

    @FXML
    private TableColumn<Venta, Integer> CantidadProductoTable;

    @FXML
    private TableColumn<Venta, String> DateProductoTable;

    @FXML
    private TableColumn<Venta, String> UbicationProductoTable;

    @FXML
    private TableColumn<Venta, String> MetodoPago;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
    }

    @FXML
    void onMouseClickedVerVentasButton(MouseEvent event) {
        ObservableList<Venta> ventas = FXCollections.observableArrayList(Venta.getListaVentas());
        HistorialVentas.setItems(ventas);
    }

    @FXML
    void initialize() {
        NameProductoTable.setCellValueFactory(cellData -> cellData.getValue().nombreProductoProperty());
        PrecioProductoTable.setCellValueFactory(cellData -> cellData.getValue().precioProductoProperty().asObject());
        CantidadProductoTable.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        DateProductoTable.setCellValueFactory(cellData -> cellData.getValue().fechaCompraProperty());
        UbicationProductoTable.setCellValueFactory(cellData -> cellData.getValue().lugarEntregaProperty());
        MetodoPago.setCellValueFactory(cellData -> cellData.getValue().metodoPagoProperty());
    }
}
