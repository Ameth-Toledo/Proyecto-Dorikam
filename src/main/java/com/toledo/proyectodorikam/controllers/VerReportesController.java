package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Reporte;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

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
    private Button DescargarButton;

    @FXML
    void OnMouseClickedDescargarButton(MouseEvent event) {
        try {
            descargarReportes();
        } catch (IOException e) {
            e.printStackTrace();
            mostrarAlertaError("Error", "Error al descargar el archivo.");
        }
    }

    private void descargarReportes() throws IOException {
        List<Reporte> listaReportes = Reporte.getListaReporte();
        if (listaReportes.isEmpty()) {
            mostrarAdvertencia("La lista de reportes está vacía.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo");
        fileChooser.setInitialFileName("reportes.txt");
        File archivo = fileChooser.showSaveDialog(null);

        if (archivo != null) {
            FileWriter escritor = new FileWriter(archivo);
            for (Reporte reporte : listaReportes) {
                escritor.write("\"𝓓𝓞𝓡𝓘𝓚𝓐𝓜\"" + System.lineSeparator());
                escritor.write(System.lineSeparator());
                escritor.write("TITULO: " + reporte.getTitulo() + System.lineSeparator());
                escritor.write("FECHA: " + reporte.getFechaReporte() + System.lineSeparator());
                escritor.write("DESCRIPCION: " + reporte.getDetalles() + System.lineSeparator());
                escritor.write(System.lineSeparator());
                escritor.write("𝑹𝒆𝒑𝒐𝒓𝒕𝒆 𝒈𝒆𝒏𝒆𝒓𝒂𝒅𝒐 𝒑𝒐𝒓 𝑨𝒅𝒎𝒊𝒏𝒊𝒔𝒕𝒓𝒂𝒅𝒐𝒓, 𝒅𝒆 𝒍𝒂 𝒆𝒎𝒑𝒓𝒆𝒔𝒂 𝑫𝒐𝒓𝒊𝒌𝒂𝒎." + System.lineSeparator());
                escritor.write(System.lineSeparator());
                escritor.write("𝑺𝒖𝒄𝒖𝒓𝒔𝒂𝒍𝒆𝒔 𝒖𝒃𝒊𝒄𝒂𝒅𝒂𝒔 𝒆𝒏: \n✅ 12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n📍GoogleMaps: https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA ");
                escritor.write(System.lineSeparator());
                escritor.write("\n✅ Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n📍GoogleMaps: https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9" + System.lineSeparator());
                escritor.write(System.lineSeparator());
            }
            escritor.close();
            mostrarAlertaExito("Éxito", "Archivo descargado correctamente como '" + archivo.getName() + "'.");
        }
    }

    Stage callExit = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Realizar Venta\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
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
    private void mostrarAlertaExito(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        TituloColumn.setCellValueFactory(cellData -> cellData.getValue().tituloProperty());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaReporteProperty());
        ContenidoColumn.setCellValueFactory(cellData -> cellData.getValue().detallesProperty());
    }
}
