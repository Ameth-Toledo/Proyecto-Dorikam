package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Apartar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class VerApartadosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button VerApartadosButton;

    @FXML
    private TableView<Apartar> tablaProductosApartados;

    @FXML
    private TableColumn<Apartar, String> NameColumn;

    @FXML
    private TableColumn<Apartar, Integer> IdColumnColumn;

    @FXML
    private TableColumn<Apartar, String> FechaColumn;

    @FXML
    private TableColumn<Apartar, String> CategoriaColumn;

    @FXML
    private TableColumn<Apartar, String> UbicationColumn;

    @FXML
    private TableColumn<Apartar, Integer> CantidadColumn;

    @FXML
    private TableColumn<Apartar, Double> AbonadoColumn;

    @FXML
    private TableColumn<Apartar, Double> RestanteColumn;

    @FXML
    private Button DescargarReporteButton;

    @FXML
    void OnMouseClickedDescargarReporteButton(MouseEvent event) {
        try {
            descargarReportes();
        } catch (IOException e) {
            mostrarAlertaError("Error", "Ocurrió un error al descargar el reporte.");
            e.printStackTrace();
        }
    }
    private void descargarReportes() throws IOException {
        List<Apartar> listaApartados = Apartar.getListaApartados();
        if (listaApartados.isEmpty()) {
            mostrarAdvertencia("La lista de apartados está vacía.");
            return;
        }

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar archivo");
        fileChooser.setInitialFileName("apartados.txt");
        File archivo = fileChooser.showSaveDialog(null);

        if (archivo != null) {
            FileWriter escritor = new FileWriter(archivo);
            for (Apartar apartado : listaApartados) {
                escritor.write("\"𝓓𝓞𝓡𝓘𝓚𝓐𝓜\"" + System.lineSeparator());
                escritor.write(System.lineSeparator());
                escritor.write("𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔 𝑨𝒑𝒂𝒓𝒕𝒂𝒅𝒐𝒔:");
                escritor.write(System.lineSeparator());
                escritor.write("Nombre: " + apartado.getNombre() + System.lineSeparator());
                escritor.write("Producto: " + apartado.getProducto() + System.lineSeparator());
                escritor.write("ID: " + apartado.getId() + System.lineSeparator());
                escritor.write("Fecha: " + apartado.getFecha() + System.lineSeparator());
                escritor.write("Categoría: " + apartado.getCategoria() + System.lineSeparator());
                escritor.write("Ubicación: " + apartado.getUbicacion() + System.lineSeparator());
                escritor.write("Cantidad de Productos: " + apartado.getCantidadDeProductos() + System.lineSeparator());
                escritor.write("Monto Abonado: " + apartado.getMontoAbonado() + System.lineSeparator());
                escritor.write("Monto Restante: " + apartado.getMontoRestante() + System.lineSeparator());
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

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedVerApartadosButton(MouseEvent event) {
        List<Apartar> apartados = Apartar.getListaApartados();
        ObservableList<Apartar> observableApartados = FXCollections.observableArrayList(apartados);
        tablaProductosApartados.setItems(observableApartados);
    }
    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
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
    @FXML
    void initialize() {
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert VerApartadosButton != null : "fx:id=\"VerApartadosButton\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert tablaProductosApartados != null : "fx:id=\"tablaProductosApartados\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert NameColumn != null : "fx:id=\"NameColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert IdColumnColumn != null : "fx:id=\"IdColumnColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert FechaColumn != null : "fx:id=\"FechaColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert CategoriaColumn != null : "fx:id=\"CategoriaColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert UbicationColumn != null : "fx:id=\"UbicationColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert CantidadColumn != null : "fx:id=\"CantidadColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert AbonadoColumn != null : "fx:id=\"AbonadoColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert RestanteColumn != null : "fx:id=\"RestanteColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";

        NameColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        IdColumnColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        CategoriaColumn.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        UbicationColumn.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        CantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadDeProductosProperty().asObject());
        AbonadoColumn.setCellValueFactory(cellData -> cellData.getValue().montoAbonadoProperty().asObject());
        RestanteColumn.setCellValueFactory(cellData -> cellData.getValue().montoRestanteProperty().asObject());
    }
}
