package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Producto;
import com.toledo.proyectodorikam.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.List;

public class CancelarVentaController {

    @FXML
    private Button ConfirmarButton;

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
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String idProducto = IDProductoTextField.getText();
        Producto producto = buscarProducto(idProducto);

        if (producto != null) {
            Venta venta = buscarVentaPorProducto(producto);
            if (venta != null) {
                Venta.getListaVentas().remove(venta);
                producto.setStock(producto.getStock() + venta.cantidadProperty().get());
                mostrarAlertaInformation("Venta cancelada", "La venta ha sido cancelada correctamente.");
            } else {
                mostrarAlertaError("Error", "No se encontró una venta para el producto especificado.");
            }
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
        System.out.println("venta");
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

    private Producto buscarProducto(String id) {
        List<Producto> listaProductos = Producto.getListaProductos();
        for (Producto producto : listaProductos) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    private Venta buscarVentaPorProducto(Producto producto) {
        List<Venta> listaVentas = Venta.getListaVentas();
        for (Venta venta : listaVentas) {
            if (venta.nombreProductoProperty().get().equals(producto.getNombre()) && venta.precioProductoProperty().get() == producto.getPrecio()) {
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
}