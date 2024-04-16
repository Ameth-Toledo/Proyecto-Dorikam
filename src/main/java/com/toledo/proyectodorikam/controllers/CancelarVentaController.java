package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Producto;
import com.toledo.proyectodorikam.models.Venta;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class CancelarVentaController {

    @FXML
    private Button confirmarButton;

    @FXML
    private Button exitButton;

    @FXML
    private TextField idProductoTextField;

    @FXML
    private TextField nombreClienteTextField;

    @FXML
    private TextField nombreProductoTextField;

    @FXML
    private TextField precioProductoTextField11;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String idProducto = idProductoTextField.getText();
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
        Stage stage = (Stage) exitButton.getScene().getWindow();
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