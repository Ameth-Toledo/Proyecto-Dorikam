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

public class MenuAdministradorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button RealizarButton;

    @FXML
    private Button VerProductos;

    @FXML
    private Button UbicarButton;

    @FXML
    private Button CancelarButton;

    @FXML
    private Button ReportesButton;

    @FXML
    private Button ContarButton;

    @FXML
    private Button EntregasButton;

    @FXML
    void OnMouseClickedCancelarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedEntregasButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
    Stage callRealizarVenta = new Stage();
    @FXML
    void OnMouseClickedRealizarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("realizar-venta-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callRealizarVenta.setTitle("Realizar: \"Administrador\"");
        callRealizarVenta.setScene(scene);
        callRealizarVenta.show();
    }

    @FXML
    void OnMouseClickedReportesButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedUbicarButton(MouseEvent event) {

    }
    Stage callVer = new Stage();
    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();
    }

    @FXML
    void initialize() {
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert RealizarButton != null : "fx:id=\"RealizarButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert VerProductos != null : "fx:id=\"VerProductos\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert UbicarButton != null : "fx:id=\"UbicarButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert CancelarButton != null : "fx:id=\"CancelarButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert ReportesButton != null : "fx:id=\"ReportesButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert ContarButton != null : "fx:id=\"ContarButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";
        assert EntregasButton != null : "fx:id=\"EntregasButton\" was not injected: check your FXML file 'menu-administrador-view.fxml'.";

    }
}
