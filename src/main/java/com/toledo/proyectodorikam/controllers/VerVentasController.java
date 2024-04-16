package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Venta;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class VerVentasController {

    @FXML
    private Button exitButton;

    @FXML
    private Button verVentasButton;

    @FXML
    private TableView<Venta> historialVentas;

    @FXML
    private TableColumn<Venta, String> nameProductoTable;

    @FXML
    private TableColumn<Venta, Double> precioProductoTable;

    @FXML
    private TableColumn<Venta, Integer> cantidadProductoTable;

    @FXML
    private TableColumn<Venta, String> dateProductoTable;

    @FXML
    private TableColumn<Venta, String> ubicationProductoTable;

    @FXML
    private TableColumn<Venta, String> metodoPago;

    Stage callExit = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Realizar Venta\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
        cerrarVentana();
    }

    public void cerrarVentana() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedVerVentasButton(MouseEvent event) {
        ObservableList<Venta> ventas = FXCollections.observableArrayList(Venta.getListaVentas());
        historialVentas.setItems(ventas);
    }

    @FXML
    void initialize() {
        nameProductoTable.setCellValueFactory(cellData -> cellData.getValue().nombreProductoProperty());
        precioProductoTable.setCellValueFactory(cellData -> cellData.getValue().precioProductoProperty().asObject());
        cantidadProductoTable.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        dateProductoTable.setCellValueFactory(cellData -> cellData.getValue().fechaCompraProperty());
        ubicationProductoTable.setCellValueFactory(cellData -> cellData.getValue().lugarEntregaProperty());
        metodoPago.setCellValueFactory(cellData -> cellData.getValue().metodoPagoProperty());
    }
}
