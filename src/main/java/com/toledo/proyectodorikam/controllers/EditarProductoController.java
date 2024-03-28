package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EditarProductoController {
    private ArrayList<Producto> listaProductos;

    public EditarProductoController() {
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField PriceProduct;

    @FXML
    private TextField CategoriaProduct;

    @FXML
    private TextField UbicationProduct;

    @FXML
    private TextField DateProduct;

    @FXML
    private TextField IDProduct;

    @FXML
    private Button ConfirmarButton;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        if (camposVacios()) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            String nombreProducto = NameProduct.getText();
            Producto producto = buscarProductoPorNombre(nombreProducto);

            if (producto != null){
                producto.setIDProducto(IDProduct.getText());
                producto.setPrecioProducto(Double.parseDouble(PriceProduct.getText()));
                producto.setCategoria(CategoriaProduct.getText());
                producto.setLugarEntrega(UbicationProduct.getText());
                producto.setFechaCompra(DateProduct.getText());

                mostrarAlertaInformacion("Éxito", "Producto actualizado exitosamente.");
            } else {
                mostrarAlertaError("Error", "El producto no existe.");
            }
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        configureEnterKey();
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
                DateProduct.requestFocus();
            }
        });

        DateProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                CategoriaProduct.requestFocus();
            }
        });

        CategoriaProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                UbicationProduct.requestFocus();
            }
        });

        UbicationProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ConfirmarButton.requestFocus();
            }
        });

        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (camposVacios()) {
                    mostrarAlertaError("Error", "Por favor, complete todos los campos.");
                } else {
                    String nombreProducto = NameProduct.getText();
                    Producto producto = buscarProductoPorNombre(nombreProducto);

                    if (producto != null) {
                        producto.setIDProducto(IDProduct.getText());
                        producto.setPrecioProducto(Double.parseDouble(PriceProduct.getText()));
                        producto.setCategoria(CategoriaProduct.getText());
                        producto.setLugarEntrega(UbicationProduct.getText());
                        producto.setFechaCompra(DateProduct.getText());

                        mostrarAlertaInformacion("Éxito", "Producto actualizado exitosamente.");
                    } else {
                        mostrarAlertaError("Error", "El producto no existe.");
                    }
                }
            }
        });
    }

    private boolean camposVacios() {
        return NameProduct.getText().isEmpty() ||
                IDProduct.getText().isEmpty() ||
                PriceProduct.getText().isEmpty() ||
                DateProduct.getText().isEmpty() ||
                CategoriaProduct.getText().isEmpty() ||
                UbicationProduct.getText().isEmpty();
    }

    private Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaInformacion(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
