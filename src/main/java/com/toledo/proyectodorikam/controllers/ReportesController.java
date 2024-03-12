package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReportesController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button ConfirmarButton;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        if (confirmarGeneracionReporte()){
            generarReporte();
            salirReporte();
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        salirReporte();
    }
    private boolean confirmarGeneracionReporte() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Generación de Reporte");
        alert.setHeaderText("¿Estás seguro de generar el reporte?");
        alert.setContentText("Esta acción no se puede deshacer.");

        return alert.showAndWait().filter(response -> response == ButtonType.OK).isPresent();
    }
    private void generarReporte(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Reporte Generado");
        alert.setHeaderText(null);
        alert.setContentText("El reporte se ha generado correctamente.");
        alert.showAndWait();
    }
    private void salirReporte(){
        ((Stage) ExitButton.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
    }
}
