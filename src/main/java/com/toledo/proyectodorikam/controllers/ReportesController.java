package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Reporte;
import javafx.fxml.FXML;
import javafx.scene.control.*;
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

    public List<Reporte> getListaReportes() {
        return listaReportes;
    }
}
