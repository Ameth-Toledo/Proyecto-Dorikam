package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Reporte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class VerReportesController {

    @FXML
    private Button ExitButton;
    @FXML
    private Button verReportes;

    @FXML
    private ListView<Reporte> ReportList;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        cerrarVentana();
    }

    private void cerrarVentana() {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    public void setReportesList(ObservableList<Reporte> reportesList) {
        ReportList.setItems(reportesList);
    }

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {
        ReportList.getItems().clear();

        ReportesController reportesController = new ReportesController();
        List<Reporte> reportesList = reportesController.getListaReportes();

        if (!reportesList.isEmpty()) {
            ObservableList<Reporte> observableReportesList = FXCollections.observableArrayList(reportesList);
            ReportList.setItems(observableReportesList);
        } else {
            mostrarAdvertencia("Aún no se han generado reportes.");
        }
    }

    private void mostrarAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
