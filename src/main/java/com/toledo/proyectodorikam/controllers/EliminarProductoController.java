package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.util.List;


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
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProducto = NameProduct.getText();
        Producto productoAEliminar = buscarProductoPorNombre(nombreProducto);
        if (productoAEliminar != null) {
            Producto.eliminarProducto(productoAEliminar); // Llama al método estático de la clase Producto para eliminar el producto
            mostrarAlertaInformation("Éxito", "Producto eliminado correctamente");
        } else {
            mostrarAlertaError("Error", "No se encontró el producto a eliminar");
        }
    }

    private Producto buscarProductoPorNombre(String nombre) {
        List<Producto> listaProductos = Producto.getListaProductos(); // Obtiene la lista de productos desde la clase Producto
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = NameProduct.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProducto);
        if (productoEncontrado != null) {
            mostrarAlertaInformation("Éxito", "Producto encontrado: " + productoEncontrado.toString());
        } else {
            mostrarAlertaError("Error", "No se encontró el producto");
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        DateProduct.setText(LocalDate.now().toString());
        configureEnterKey();
    }

    private void configureEnterKey() {
        NameProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                IDProduct.requestFocus();
            }
        });

        IDProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                PriceProduct.requestFocus();
            }
        });

        PriceProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                CategoryProduct.requestFocus();
            }
        });

        CategoryProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
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
            if (event.getCode() == KeyCode.ENTER) {
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
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
