package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Reporte;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ReportesController {

    @FXML
    private Button ExitButton;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private TextArea detallesReport;

    @FXML
    private TextField fechaReport;

    @FXML
    private TextField tituloReport;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String tituloRep = tituloReport.getText();
        String fechaRep = fechaReport.getText();
        String detallesRep = detallesReport.getText();

        Reporte reporte;
        reporte = new Reporte(tituloRep, fechaRep, detallesRep);

        Reporte.generarReporte(reporte);

        mostrarAlerta("Reporte Generado", "El reporte se ha generado exitosamente");
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        salirReporte();
    }

    @FXML
    void initialize() {
        configureEnterKey();
    }

    private void configureEnterKey() {
        tituloReport.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                fechaReport.requestFocus();
            }
        });

        fechaReport.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                detallesReport.requestFocus();
            }
        });

        detallesReport.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ConfirmarButton.requestFocus();
            }
        });

        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (camposVacios()) {
                    mostrarAlertaError("Error", "Por favor, complete todos los campos.");
                } else {
                    salirReporte();
                }
            }
        });
    }

    private boolean camposVacios() {
        return tituloReport.getText().isEmpty() ||
                fechaReport.getText().isEmpty() ||
                detallesReport.getText().isEmpty();
    }

    private void salirReporte() {
        ((Stage) ExitButton.getScene().getWindow()).close();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
