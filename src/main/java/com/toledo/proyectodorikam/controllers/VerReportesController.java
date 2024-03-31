package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Reporte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VerReportesController {

    @FXML
    private Button ExitButton;

    @FXML
    private Button verReportes;

    @FXML
    private TableView<Reporte> TableReportes;

    @FXML
    private TableColumn<Reporte, String> TituloColumn;

    @FXML
    private TableColumn<Reporte, String> FechaColumn;

    @FXML
    private TableColumn<Reporte, String> ContenidoColumn;

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

    public void mostrarReportes() {
        ObservableList<Reporte> reportes = FXCollections.observableArrayList(Reporte.getListaReporte());
        TableReportes.setItems(reportes);
    }

    private void mostrarAdvertencia(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Información");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        TituloColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaReporteProperty());
        ContenidoColumn.setCellValueFactory(cellData -> cellData.getValue().detallesProperty());
    }
}
