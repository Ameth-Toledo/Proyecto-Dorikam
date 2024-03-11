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
    static {
        listaProductos.add(new Producto("Arete-manzana", 20.0, "2022-01-01", "Churrumino", "Tuxtla", "Gjjhj", 10));
        listaProductos.add(new Producto("Arete-rostro", 30.0, "2022-02-01", "Chililo", "Tuxtla", "gt67767", 15));
        listaProductos.add(new Producto("", 33.5, "", ""," ", "", 80));
    }
    @FXML
    private Button ExitButton;

    @FXML
    private TextField NombreProductoTextField;

    @FXML
    private TextField PrecioProductoTextField;

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
        String idProducto = IDProductoTextField.getText();
        String precioProductoStr = PrecioProductoTextField.getText();
        String lugarEntrega = LugarEntregaTextField.getText();
        String fechaCompra = FechaCompraTextField.getText();
        String nombreCliente = NombreClienteTextField.getText();

        if (nombreProducto.isEmpty() || idProducto.isEmpty() || precioProductoStr.isEmpty() ||
                lugarEntrega.isEmpty() || fechaCompra.isEmpty() || nombreCliente.isEmpty()) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            try {
                double precioProducto = Double.parseDouble(precioProductoStr);
                int cantidad = 1;
                Producto producto = obtenerProductoPorNombre(nombreProducto);
                if (producto == null) {
                    mostrarAlertaError("Error", "El producto no está disponible en la lista.");
                    return;
                }

                if (cantidad <= producto.getStock()) {
                    realizarVenta(producto, cantidad, precioProducto);
                    mostrarAlerta("Venta realizada", "La venta se ha realizado correctamente.\nTotal: " + calcularTotalVenta(cantidad, precioProducto));
                } else {
                    mostrarAlerta("Error", "No hay suficientes productos en el stock para realizar la venta.");
                }
            } catch (NumberFormatException e) {
                mostrarAlertaError("Error", "Ingrese un valor válido para el precio, (por ejemplo: 200.00)");
            }
        }
    }

    private Producto obtenerProductoPorNombre(String nombreProducto) {
        for (Producto producto : listaProductos) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombreProducto)) {
                return producto;
            }
        }
        return null;
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
                PrecioProductoTextField.requestFocus();
            } else if (event.getSource() == PrecioProductoTextField) {
                LugarEntregaTextField.requestFocus();
            } else if (event.getSource() == LugarEntregaTextField) {
                FechaCompraTextField.requestFocus();
            } else if (event.getSource() == FechaCompraTextField) {
                NombreClienteTextField.requestFocus();
            } else if (event.getSource() == NombreClienteTextField) {
                ConfirmarButton.requestFocus();
            } else if (event.getSource() == ConfirmarButton) {
                OnMouseClickedConfirmarButton(null);

            if (event.getTarget() instanceof TextField){
                TextField textField = (TextField) event.getTarget();
                textField.setOnAction(e ->{
                    e.consume();
                    textField.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED, "","", KeyCode.TAB, false, false, false, false ));
                    });
                }
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
    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
