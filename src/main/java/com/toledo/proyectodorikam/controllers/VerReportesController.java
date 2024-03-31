package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VerReportesController {
    @FXML
    private TableView<?> IDTabla;

    @FXML
    private TableColumn<?, ?> IDcontenido;

    @FXML
    private TableColumn<?, ?> IDfecha;

    @FXML
    private TableColumn<?, ?> IDtitulo;


    @FXML
    private Button ExitButton;

    @FXML
    private Button verReportes;

    @FXML
    private ListView<?> ReportList;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {
    }

    private void mostrarAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
