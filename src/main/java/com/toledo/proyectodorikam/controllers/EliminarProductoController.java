package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.time.LocalDate;

public class EliminarProductoController {

    @FXML
    private Button ExitButton;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField PriceProduct;

    @FXML
    private TextField CategoryProduct;

    @FXML
    private TextField UbicationProduct;

    @FXML
    private TextField DateProduct;

    @FXML
    private TextField IDProduct;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private Button BuscarButton;

    @FXML
    private ListView<Producto> listaProductos;

    private FilteredList<Producto> filteredData;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        Producto productoSeleccionado = listaProductos.getSelectionModel().getSelectedItem();
        if (productoSeleccionado != null) {
            listaProductos.getItems().remove(productoSeleccionado);
            mostrarAlertaInformation("Exito", "Producto eliminado correctamente");
        } else {
            mostrarAlertaError("Error", "Por favor, seleccione un producto a eliminar");
        }
    }

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProductoBuscado = NameProduct.getText();
        if (nombreProductoBuscado.isEmpty()) {
            mostrarAlertaError("Error", "Por favor, ingrese el nombre del producto a buscar.");
            return;
        }

        filteredData.setPredicate(producto -> {
            if (nombreProductoBuscado == null || nombreProductoBuscado.isEmpty()) {
                return true;
            }
            String nombreProducto = producto.getNombre().toLowerCase();
            return nombreProducto.contains(nombreProductoBuscado.toLowerCase());
        });
        listaProductos.setItems(filteredData);
    }


    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        configureEnterKey();
        DateProduct.setText(LocalDate.now().toString());

        ObservableList<Producto> listaProductosData = FXCollections.observableArrayList();
        FilteredList<Producto> filteredData = new FilteredList<>(listaProductosData, p -> true);

        NameProduct.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(producto -> {
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }
                String nombreProducto = producto.getNombre().toLowerCase();
                return nombreProducto.contains(newValue.toLowerCase());
            });
        });

        listaProductos.setItems(filteredData);
    }


    private void configureEnterKey() {
        NameProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                IDProduct.requestFocus();
            }
        });

        IDProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                PriceProduct.requestFocus();
            }
        });

        PriceProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                CategoryProduct.requestFocus();
            }
        });

        CategoryProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                UbicationProduct.requestFocus();
            }
        });

        UbicationProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String userInput = UbicationProduct.getText().toLowerCase().trim();
                switch (userInput) {
                    case "albania alta":
                    case "el carmen":
                    case "albania":
                        UbicationProduct.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                                "GoogleMaps: " + "https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
                        break;
                    case "las torres":
                    case "fraccionamiento las torres":
                    case "fraccionamiento":
                        UbicationProduct.setText("Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n " +
                                "GoogleMaps: "+"https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9");
                        break;
                }
            }
        });

        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (camposVacios()) {
                    mostrarAlertaError("Error", "Por favor, complete todos los campos.");
                }
            }
        });
    }

    private boolean camposVacios() {
        return NameProduct.getText().isEmpty() ||
                IDProduct.getText().isEmpty() ||
                PriceProduct.getText().isEmpty() ||
                DateProduct.getText().isEmpty() ||
                CategoryProduct.getText().isEmpty() ||
                UbicationProduct.getText().isEmpty();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlertaInformation(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
