package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.toledo.proyectodorikam.models.Producto;

import java.util.ArrayList;
import java.util.List;

public class RealizarVentaController {

    private static List<Producto> listaProductos = new ArrayList<>();

    @FXML
    private Button ExitButton;

    @FXML
    private TextField NombreProductoTextField;

    @FXML
    private TextField PrecioProductoTextField;

    @FXML
    private TextField CantidadTextField;

    @FXML
    private TextField FechaCompraTextField;

    @FXML
    private TextField NombreClienteTextField;

    @FXML
    private TextField LugarEntregaTextField;

    @FXML
    private TextField IDProductoTextField;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private ComboBox<String> pago;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProducto = NombreProductoTextField.getText();
        double precioProducto = Double.parseDouble(PrecioProductoTextField.getText());
        int cantidad = Integer.parseInt(CantidadTextField.getText());

        Producto producto = new Producto(
                nombreProducto,
                precioProducto,
                FechaCompraTextField.getText(),
                NombreClienteTextField.getText(),
                LugarEntregaTextField.getText(),
                IDProductoTextField.getText(),
                10  // Ajusta el stock según tus necesidades
        );

        if (cantidad <= producto.getStock()) {
            realizarVenta(producto, cantidad, precioProducto);
            mostrarAlerta("Venta realizada", "La venta se ha realizado correctamente.\nTotal: " + calcularTotalVenta(cantidad, precioProducto));
        } else {
            mostrarAlerta("Error", "No hay suficiente stock para realizar la venta.");
        }
    }

    private void realizarVenta(Producto producto, int cantidad, double precioUnitario) {
        producto.setStock(producto.getStock() - cantidad);
        actualizarStockEnLista(producto);
    }

    private double calcularTotalVenta(int cantidad, double precioUnitario) {
        return cantidad * precioUnitario;
    }

    private void actualizarStockEnLista(Producto producto) {
        for (Producto p : listaProductos) {
            if (p.getIDProducto().equals(producto.getIDProducto())) {
                p.setStock(producto.getStock());
                break;
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
        pago.getItems().addAll("Efectivo", "Tarjeta", "Transferencia");

        NombreProductoTextField.setOnKeyPressed(this::handleEnterKey);
        PrecioProductoTextField.setOnKeyPressed(this::handleEnterKey);
        CantidadTextField.setOnKeyPressed(this::handleEnterKey);
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
            if (event.getSource() == ConfirmarButton) {
                OnMouseClickedConfirmarButton(null);
            }
        }
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
