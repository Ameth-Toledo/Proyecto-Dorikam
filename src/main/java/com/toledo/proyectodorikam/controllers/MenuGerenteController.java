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

        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) {
        salirMenuGerente();
    }

    Stage callEditar = new Stage();
    @FXML
    void OnMouseClickedEditarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editar-producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEditar.setTitle("Menu: \"Ver Productos\"");
        callEditar.setScene(scene);
        callEditar.show();

        salirMenuGerente();
    }

    Stage callEliminar = new Stage();

    @FXML
    void OnMouseClickedEliminarButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("eliminar-producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEliminar.setTitle("Menu: \"Ver eliminar\"");
        callEliminar.setScene(scene);
        callEliminar.show();
        salirMenuGerente();
    }


    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedUbicarButton(MouseEvent event) {
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedVentasButton(MouseEvent event) {
        salirMenuGerente();
    }
    Stage callVer = new Stage();
    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tipo-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();

        salirMenuGerente();
    }
    @FXML
    void OnMouseClickedVerReportesButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-reportes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ver Reportes");
        stage.setScene(scene);
        stage.show();

        salirMenuGerente();
    }
    private void salirMenuGerente() {
        ((Stage) ExitButton.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
    }
}
