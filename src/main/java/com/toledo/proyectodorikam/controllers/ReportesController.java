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
import java.util.ArrayList;
import java.util.List;

public class ReportesController {

    private List<Reporte> listaReportes = new ArrayList<>();

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
        guardarReporte();
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
                    guardarReporte();
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

    private void guardarReporte() {
        String titulo = tituloReport.getText();
        String fecha = fechaReport.getText();
        String detalles = detallesReport.getText();

        Reporte nuevoReporte = new Reporte(titulo, fecha, detalles);
        listaReportes.add(nuevoReporte);
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    public List<Reporte> getListaReportes() {
        return listaReportes;
    }
}
