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
    private Button Apartado;

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
        salirMenuAdministrador();
    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) {
        salirMenuAdministrador();
    }

    @FXML
    void OnMouseClickedEntregasButton(MouseEvent event) {
        salirMenuAdministrador();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        salirMenuAdministrador();
    }
    Stage callRealizarVenta = new Stage();
    @FXML
    void OnMouseClickedRealizarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("realizar-venta-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callRealizarVenta.setTitle("Realizar: \"Administrador\"");
        callRealizarVenta.setScene(scene);
        callRealizarVenta.show();

        salirMenuAdministrador();
    }
    @FXML
    void OnMouseClickedReportesButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("generar-reportes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callRealizarVenta.setTitle("Realizar: \"Administrador\"");
        callRealizarVenta.setScene(scene);
        callRealizarVenta.show();

        salirMenuAdministrador();
    }

    @FXML
    void OnMouseClickedUbicarButton(MouseEvent event) {
        salirMenuAdministrador();
    }
    Stage callVer = new Stage();
    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();

        salirMenuAdministrador();
    }

    @FXML
    void onMouseClickedApartado(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("apartar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver productos apartados\"");
        callVer.setScene(scene);
        callVer.show();

        salirMenuAdministrador();
    }
    private void salirMenuAdministrador() {
        ((Stage) ExitButton.getScene().getWindow()).close();
    }
    @FXML
    void initialize() {
    }
}
