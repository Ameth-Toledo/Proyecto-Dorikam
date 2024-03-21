package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.toledo.proyectodorikam.models.Eliminar;

public class EliminarProductoController {

    @FXML
    private Button ExitButton;

    @FXML
    private TextField Producto;

    @FXML
    private Button confrmar;

    @FXML
    void OnMouseClickedConfirmar(MouseEvent event) {
        String nombreProducto = Producto.getText();

        if (nombreProducto.isEmpty()) {
            mostrarAlertaError("Error", "Por favor, ingrese el nombre del producto a eliminar.");
            return;
        }

        Eliminar.eliminarProducto(nombreProducto);
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
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
