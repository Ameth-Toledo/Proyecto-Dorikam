package com.toledo.proyectodorikam.controllers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Venta;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VerEntregadosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button verReportes;

    @FXML
    private TableView<Venta> TableProductosEntregados;

    @FXML
    private TableColumn<Venta, String> NombreColumn;

    @FXML
    private TableColumn<Venta, Integer> CantidadColumn;

    @FXML
    private TableColumn<Venta, String> UbicacionColumn;

    @FXML
    private TableColumn<Venta, String> FechaColumn;

    @FXML
    private Button DescargarButton;

    @FXML
    void OnMouseClickedDescargarButton(MouseEvent event) {
        descargarEntregados();
    }

    Stage callExit = new Stage();

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Realizar Venta\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
        cerrarVentana();
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {
        mostrarEntregados();
    }

    @FXML
    void initialize() {
        NombreColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProductoProperty());
        CantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadProperty().asObject());
        UbicacionColumn.setCellValueFactory(cellData -> cellData.getValue().lugarEntregaProperty());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaCompraProperty());
    }
    private void mostrarEntregados() {
        TableProductosEntregados.setItems(FXCollections.observableList(Venta.getListaVentas()));
    }

    private void descargarEntregados() {
        List<Venta> listaVentas = TableProductosEntregados.getItems();

        if (listaVentas.isEmpty()) {
            mostrarAdvertencia("La lista de ventas está vacía.");
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Guardar Productos Entregados");
        fileChooser.setInitialFileName("Productos Entregados.txt");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de texto", "*.txt"));
        File archivo = fileChooser.showSaveDialog(null);

        if (archivo != null) {
            try {
                FileWriter escritor = new FileWriter(archivo);
                for (Venta venta : listaVentas) {
                    escritor.write("\"𝓓𝓞𝓡𝓘𝓚𝓐𝓜\"" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                    escritor.write("𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔 𝑬𝒏𝒕𝒓𝒆𝒈𝒂𝒅𝒐𝒔:"+System.lineSeparator());
                    escritor.write("NOMBRE DEL PRODUCTO: " + venta.getNombreProducto() + "\n");
                    escritor.write("CANTIDAD: " + venta.getCantidad() + "\n");
                    escritor.write("LUGAR DE ENTREGA: " + venta.getLugarEntrega() + "\n");
                    escritor.write("FECHA DE COMPRA: " + venta.getFechaCompra() + "\n\n");
                    escritor.write(System.lineSeparator());
                    escritor.write("𝑺𝒖𝒄𝒖𝒓𝒔𝒂𝒍𝒆𝒔 𝒖𝒃𝒊𝒄𝒂𝒅𝒂𝒔 𝒆𝒏: \n✅ 12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n📍GoogleMaps: https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA ");
                    escritor.write(System.lineSeparator());
                    escritor.write("\n✅ Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n📍GoogleMaps: https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9" + System.lineSeparator());
                    escritor.write(System.lineSeparator());
                }
                escritor.close();
                mostrarAlertaExito("Éxito", "Se ha descargado el archivo correctamente como '" + archivo.getName() + "'.");
            } catch (IOException e) {
                e.printStackTrace();
                mostrarAlertaError("Error", "Se produjo un error al intentar guardar el archivo.");
            }
        }
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
}

