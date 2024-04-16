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
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class UbicarProductosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Producto> tableUbication;

    @FXML
    private TableColumn<Producto, String> nombre;

    @FXML
    private TableColumn<Producto, String> idColumn;

    @FXML
    private TableColumn<Producto, Double> precioColumn;

    @FXML
    private TableColumn<Producto, String> categoriaColumn;

    @FXML
    private TableColumn<Producto, Integer> stockColumn;

    @FXML
    private TableColumn<Producto, String> ubicationColumn;

    @FXML
    private Button ubicationsButton;

    @FXML
    private Button exitButton;

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


    @FXML
    void onMouseClickedUbicationsButton(MouseEvent event) {
        mostrarUbications();
    }

    @FXML
    void initialize() {
        nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        idColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        precioColumn.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        categoriaColumn.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        stockColumn.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        ubicationColumn.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
    }

    private void mostrarUbications() {
        tableUbication.setItems(FXCollections.observableList(Producto.getListaProductos()));
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
}
