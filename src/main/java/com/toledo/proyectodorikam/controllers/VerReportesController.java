package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Reporte;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VerReportesController {

    @FXML
    private Button ExitButton;

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
}
