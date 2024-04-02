package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Producto;
import com.toledo.proyectodorikam.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CancelarVentaController {

    @FXML
    private Button ExitButton;

    @FXML
    private TextField IDProductoTextField;

    @FXML
    private TextField NombreClienteTextField;

    @FXML
    private TextField NombreProductoTextField;

    @FXML
    private TextField PrecioProductoTextField11;

    @FXML
    private Button ConfirmarButton;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProducto = NombreProductoTextField.getText();
        Producto producto = buscarProducto(nombreProducto);

        if (producto != null) {
            Venta venta = buscarVentaPorProducto(producto);
            if (venta != null) {
                Venta.listaVentas.remove(venta);
                producto.setStock(producto.getStock() + venta.getCantidad());
                limpiarCampos();
                mostrarAlertaInformation("Venta cancelada", "La venta ha sido cancelada correctamente.");
            } else {
                mostrarAlertaError("Error", "No se encontró una venta para el producto especificado.");
            }
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
        System.out.println("ventas");
        for (Venta p : Venta.getListaVentas()) {
            System.out.println(p.toString());
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

    private Producto buscarProducto(String nombre) {
        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private Venta buscarVentaPorProducto(Producto producto) {
        for (Venta venta : Venta.getListaVentas()) {
            if (venta.getProducto().equals(producto)) {
                return venta;
            }
        }
        return null;
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlertaInformation(String title, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private void limpiarCampos () {
        IDProductoTextField.clear();
        NombreClienteTextField.clear();
        NombreProductoTextField.clear();
        PrecioProductoTextField11.clear();
    }
}
