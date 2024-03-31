package com.toledo.proyectodorikam.controllers;

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
        salirReporte();
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
}
