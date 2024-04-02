package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Producto;
import com.toledo.proyectodorikam.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Optional;


public class RealizarVentaController {

    @FXML
    private Button ExitButton;

    @FXML
    private TextField NombreProductoTextField;

    @FXML
    private TextField FechaCompraTextField;

    @FXML
    private TextField NombreClienteTextField;

    @FXML
    private TextField LugarEntregaTextField;

    @FXML
    private TextField IDProductoTextField;

    @FXML
    private TextField PrecioProductoTextField11;

    @FXML
    private TextField cantidadComprar;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private ComboBox<String> pago;


    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String idProducto = IDProductoTextField.getText();
        int cantidad = Integer.parseInt(cantidadComprar.getText());

        Producto producto = buscarProducto(idProducto);

        if (producto != null) {
            if (producto.getStock() >= cantidad) {
                double totalPagar = producto.getPrecio() * cantidad;
                String mensaje = "Total a pagar: $" + totalPagar + "\n¿Desea confirmar la venta?";
                if (confirmarVenta(mensaje)) {
                    Venta venta = new Venta(producto, cantidad, pago.getValue());
                    venta.listaVentas.add(venta);
                    producto.setStock(producto.getStock() - cantidad);

                    mostrarAlertaInformation("Venta realizada", "La venta se ha realizado correctamente.");
                } else {
                    mostrarAlertaInformation("Venta cancelada", "La venta ha sido cancelada.");
                }
            } else {
                mostrarAlertaError("Error", "No hay suficiente stock para realizar la venta.");
            }
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
    }


    private Producto buscarProducto(String id) {
        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getId().equals(id)) {
                return producto;
            }
        }
        return null;
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        pago.getItems().addAll("Efectivo", "Tarjeta", "Transferencia");

        NombreProductoTextField.setOnKeyPressed(this::handleEnterKey);
        PrecioProductoTextField11.setOnKeyPressed(this::handleEnterKey);
        FechaCompraTextField.setOnKeyPressed(this::handleEnterKey);
        NombreClienteTextField.setOnKeyPressed(this::handleEnterKey);
        LugarEntregaTextField.setOnKeyPressed(this::handleEnterKey);
        IDProductoTextField.setOnKeyPressed(this::handleEnterKey);

        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                OnMouseClickedConfirmarButton(null);
            }
        });
    }

    private void handleEnterKey(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            event.consume();
            if (event.getSource() == NombreProductoTextField) {
                IDProductoTextField.requestFocus();
            } else if (event.getSource() == IDProductoTextField) {
                PrecioProductoTextField11.requestFocus();
            } else if (event.getSource() == PrecioProductoTextField11) {
                LugarEntregaTextField.requestFocus();
            } else if (event.getSource() == LugarEntregaTextField) {
                FechaCompraTextField.requestFocus();
            } else if (event.getSource() == FechaCompraTextField) {
                NombreClienteTextField.requestFocus();
            } else if (event.getSource() == NombreClienteTextField) {
                ConfirmarButton.requestFocus();
            } else if (event.getSource() == ConfirmarButton) {
                OnMouseClickedConfirmarButton(null);
            }
        }
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
    private boolean confirmarVenta(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar Venta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        ButtonType buttonTypeConfirmar = new ButtonType("Confirmar");
        ButtonType buttonTypeCancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
        alert.getButtonTypes().setAll(buttonTypeConfirmar, buttonTypeCancelar);

        Optional<ButtonType> result = alert.showAndWait();
        return result.isPresent() && result.get() == buttonTypeConfirmar;
    }
}
