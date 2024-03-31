package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Reporte;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {
        if (Reporte.getListaReporte().isEmpty()){
            mostrarAdvertencia("Aún no se han generado reportes");
        } else {
            mostrarReportes();
        }
    }
    public void mostrarReportes () {
        ReportList.getItems().addAll(Reporte.getListaReporte());
    }

    private void mostrarAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
