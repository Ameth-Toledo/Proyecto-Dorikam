package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.models.Administrador;
import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class AgregarProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField categoriaProducto;

    @FXML
    private TextField fechaIngreso;

    @FXML
    private Button guardarProducto;

    @FXML
    private TextField idProducto;

    @FXML
    private TextField nombreProducto;

    @FXML
    private TextField precioProducto;

    @FXML
    private TextField ubicacionProducto;
    Administrador administrador;

    @FXML
    void OnMouseClickConfirmar(MouseEvent event) {
        String nombre = nombreProducto.getText();
        String fecha = fechaIngreso.getText();
        String id = idProducto.getText();
        String categoria = categoriaProducto.getText();
        String precioText = precioProducto.getText();
        String ubicacion = ubicacionProducto.getText();

        try {
            double precio = Double.parseDouble(precioText);
            if (nombre.isEmpty() || fecha.isEmpty() || id.isEmpty() || categoria.isEmpty() || ubicacion.isEmpty()) {
                mostrarAlerta("Error", "Por favor complete todos los campos.");
                return;
            }

            Producto producto = new Producto(nombre, precio, fecha, "", "", id, 0);
            administrador.agregarProducto(producto);

            mostrarAlerta("Éxito", "Producto agregado correctamente.");

        } catch (NumberFormatException e) {
            mostrarAlerta("Error", "El precio ingresado no es un número válido: " + precioText);
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    void initialize() {
    }
    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
