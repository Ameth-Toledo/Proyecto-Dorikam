package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Producto;
import com.toledo.proyectodorikam.models.Venta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
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
    private Button BuscarButton;

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = NombreProductoTextField.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProducto);

        if (productoEncontrado != null) {
            llenarInformacionProducto(productoEncontrado);
            mostrarAlertaInformation("Exito", "Producto encontrado: " + productoEncontrado.getNombre());
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
    }

    private Producto buscarProductoPorNombre(String nombre) {
        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private void llenarInformacionProducto(Producto producto) {
        IDProductoTextField.setText(producto.getId());
        PrecioProductoTextField11.setText(String.valueOf(producto.getPrecio()));
        FechaCompraTextField.setText(String.valueOf(producto.getFecha()));
        NombreProductoTextField.setText(String.valueOf(producto.getNombre()));
        LugarEntregaTextField.setText(String.valueOf(producto.getUbicacion()));
    }

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String idProducto = IDProductoTextField.getText();
        int cantidad = Integer.parseInt(cantidadComprar.getText());
        String nombreProducto = NombreProductoTextField.getText();
        String fechaCompra = FechaCompraTextField.getText();
        String nombreCliente = NombreClienteTextField.getText();
        String lugarEntrega = LugarEntregaTextField.getText();
        double precioProducto = Double.parseDouble(PrecioProductoTextField11.getText());

        Producto producto = buscarProducto(idProducto);

        if (producto != null) {
            if (producto.getStock() >= cantidad) {
                double totalPagar = producto.getPrecio() * cantidad;
                String mensaje = "Total a pagar: $" + totalPagar + "\n¿Desea confirmar la venta?";
                if (confirmarVenta(mensaje)) {
                    Venta venta = new Venta(producto, cantidad, pago.getValue(), nombreProducto, fechaCompra, nombreCliente, lugarEntrega, precioProducto);
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
        System.out.println("venta");
        for (Venta p : Venta.getListaVentas()) {
            System.out.println(p.toString());
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

    Stage callExit = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Realizar Venta\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
        cerrarVentana();
    }

    public void cerrarVentana() {
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
