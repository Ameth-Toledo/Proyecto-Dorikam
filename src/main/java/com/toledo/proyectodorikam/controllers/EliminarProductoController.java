package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import com.toledo.proyectodorikam.models.Eliminar;

public class EliminarProductoController {

    @FXML
    private TextField NameProduct;

    @FXML
    private Button ConfirmarButton;

    @FXML
    void OnMouseClickedConfirmarButton() {
        String nombreProducto = NameProduct.getText();
        if (!nombreProducto.isEmpty()) {
            eliminarProducto(nombreProducto);
        } else {
            mostrarAlertaError("Error", "Por favor, ingrese el nombre del producto a eliminar.");
        }
    }

    private void eliminarProducto(String nombreProducto) {
        Eliminar.eliminarProducto(nombreProducto);
        mostrarAlerta("Producto eliminado", "El producto ha sido eliminado correctamente.");
    }

    private void mostrarAlerta(String titulo, String contenido) {
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
