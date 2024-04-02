package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Producto;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UbicarProductosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button EntregasButton;

    @FXML
    private TableView<Producto> TableUbication;

    @FXML
    private TableColumn<Producto, String> Nombre;

    @FXML
    private TableColumn<Producto, String> IdColumn;

    @FXML
    private TableColumn<Producto, Double> PrecioColumn;

    @FXML
    private TableColumn<Producto, String> CategoriaColumn;

    @FXML
    private TableColumn<Producto, Integer> StockColumn;

    @FXML
    private TableColumn<Producto, String> UbicationColumn;

    @FXML
    private Button UbicationsButton;

    @FXML
    private Button ExitButton;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    Stage callEntregar = new Stage();
    @FXML
    void onMouseClickedEntregasButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("realizar-venta-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEntregar.setTitle("Menu: \"Ver Ventas\"");
        callEntregar.setScene(scene);
        callEntregar.show();
    }

    @FXML
    void onMouseClickedUbicationsButton(MouseEvent event) {
        mostrarUbications();
    }

    @FXML
    void initialize() {
        Nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        IdColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        PrecioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        CategoriaColumn.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        StockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        UbicationColumn.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
    }

    private void mostrarUbications() {
        TableUbication.setItems(FXCollections.observableList(Producto.getListaProductos()));
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
}
