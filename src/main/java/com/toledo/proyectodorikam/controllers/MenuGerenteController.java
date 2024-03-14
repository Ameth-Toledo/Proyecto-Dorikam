package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuGerenteController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button AgregarButton;

    @FXML
    private Button VerProductos;

    @FXML
    private Button UbicarButton;

    @FXML
    private Button EditarButton;

    @FXML
    private Button VentasButton;

    @FXML
    private Button ContarButton;

    @FXML
    private Button EliminarButton;


    Stage callAgregar = new Stage();

    @FXML
    void OnMouseClickedAgregarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("agregar-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callAgregar.setTitle("Agregar productos");
        callAgregar.setScene(scene);
        callAgregar.show();
    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedEditarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedEliminarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnMouseClickedUbicarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedVentasButton(MouseEvent event) {

    }
    Stage callVer = new Stage();
    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tipo-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();
    }
    @FXML
    void OnMouseClickedVerReportesButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-reportes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ver Reportes");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void initialize() {
    }
}
