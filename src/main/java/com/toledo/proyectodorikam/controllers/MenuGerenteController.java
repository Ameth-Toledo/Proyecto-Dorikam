package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuGerenteController {

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

    @FXML
    void OnMouseClickedAgregarButton(MouseEvent event) throws IOException {
        abrirAgregarButton();
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) throws IOException {
        abrirContarButton();
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedEditarButton(MouseEvent event) throws IOException {
        abrirEditarButton();
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedEliminarButton(MouseEvent event) throws IOException {
        abrirEliminarButton();
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        salirMenuGerente();
    }

    @FXML void OnMouseClickedUbicarButton(MouseEvent event) {
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedVentasButton(MouseEvent event) {
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        abrirVerButton();
        salirMenuGerente();
    }

    @FXML
    void OnMouseClickedVerReportesButton(MouseEvent event) throws IOException {
        salirMenuGerente();
    }

    private void salirMenuGerente() {
        ((Stage) ExitButton.getScene().getWindow()).close();
    }

    Stage callAgregar = new Stage();

    private void abrirAgregarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("agregar-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callAgregar.setTitle("Agregar Productos");
        callAgregar.setScene(scene);
        callAgregar.show();
    }

    Stage callContar = new Stage();

    private void abrirContarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callContar.setTitle("Inicio de Sesion: \"Gerente\"");
        callContar.setScene(scene);
        callContar.show();
    }

    Stage callEditar = new Stage();
    private void abrirEditarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editar-producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEditar.setTitle("Menu: \"Ver Productos\"");
        callEditar.setScene(scene);
        callEditar.show();
    }

    Stage callEliminar = new Stage();
    private void abrirEliminarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("eliminar-producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEliminar.setTitle("Menu: \"eliminar Productos\"");
        callEliminar.setScene(scene);
        callEliminar.show();
    }

    Stage callVer = new Stage();
    private void abrirVerButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tipo-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();
    }

    private void abrirVentasButton() throws IOException {

    }

    private void abrirReportesButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-reportes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ver Reportes");
        stage.setScene(scene);
        stage.show();
    }

    private void abrirUbicarButton() throws IOException {

    }

    private void abrirContarProductos() throws IOException {

    }
    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void initialize() {
        Platform.runLater(() -> {
            Scene scene = ExitButton.getScene();
            if (scene != null) {
                scene.setOnKeyPressed(event -> {
                    switch (event.getCode()) {
                        case F1:
                            try {
                                abrirAgregarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F2:
                            try {
                                abrirEditarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F3:
                            try {
                                abrirEliminarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F4:
                            try {
                                abrirVerButton();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        case F5:
                            try {
                                abrirVentasButton();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        case F6:
                            try {
                                abrirReportesButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F7:
                            try {
                                abrirUbicarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F8:
                            try {
                                abrirContarProductos();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case ESCAPE:
                            try {
                                cerrarVentana();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    }
}
