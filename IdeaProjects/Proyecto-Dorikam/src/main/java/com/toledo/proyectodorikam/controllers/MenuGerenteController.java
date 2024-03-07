package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
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

    @FXML
    void OnMouseClickedAgregarButton(MouseEvent event) {

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

    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) {

    }

    @FXML
    void initialize() {
    }
}
