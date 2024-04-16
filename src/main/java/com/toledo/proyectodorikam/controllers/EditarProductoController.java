package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class EditarProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private TextField nameProduct;

    @FXML
    private TextField priceProduct;

    @FXML
    private TextField categoriaProduct;

    @FXML
    private TextField ubicationProduct;

    @FXML
    private TextField dateProduct;

    @FXML
    private TextField idProduct;

    @FXML
    private TextField cantidadStock;

    @FXML
    private Button confirmarButton;

    @FXML
    private Button buscarButton;

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProductoBuscado = nameProduct.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);
        if (productoEncontrado != null) {
            mostrarProductoEncontrado(productoEncontrado);
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
    }

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProductoBuscado = nameProduct.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);
        if (productoEncontrado != null) {
            editarProducto(productoEncontrado);
            mostrarAlertaInformation("Exito", "Producto editado correctamente.");
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
    }

    Stage callRegresar = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callRegresar.setTitle("Menu: \"Gerente\"");
        callRegresar.setScene(scene);
        callRegresar.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callRegresar.show();

        cerrarVentana();
    }

    @FXML
    void initialize() {
        configureEnterKey();
    }

    private void configureEnterKey() {
        nameProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                idProduct.requestFocus();
            }
        });

        idProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                priceProduct.requestFocus();
            }
        });

        priceProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                dateProduct.requestFocus();
            }
        });

        dateProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                categoriaProduct.requestFocus();
            }
        });

        categoriaProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ubicationProduct.requestFocus();
            }
        });

        ubicationProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                cantidadStock.requestFocus();
            }
        });
        cantidadStock.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                confirmarButton.requestFocus();
            }
        });

        confirmarButton.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (camposVacios()) {
                    mostrarAlertaError("Error", "Por favor, complete todos los campos.");
                } else {
                    mostrarAlertaError("Error", "El producto no existe.");
                }
            }
        });
    }

    private Producto buscarProductoPorNombre(String nombre) {
        List<Producto> listaProductos = Producto.getListaProductos();
        for (Producto producto : listaProductos) {
            if (producto.getNombre().equals(nombre)) {
                return producto;
            }
        }
        return null;
    }

    private void editarProducto(Producto producto) {
        producto.setPrecio(Double.parseDouble(priceProduct.getText()));
        producto.setCategoria(categoriaProduct.getText());
        producto.setUbicacion(ubicationProduct.getText());
        producto.setFecha(dateProduct.getText());
        producto.setId(idProduct.getText());
        producto.setStock(Integer.parseInt(cantidadStock.getText()));
    }

    private void mostrarProductoEncontrado(Producto producto) {
        nameProduct.setText(producto.getNombre());
        priceProduct.setText(String.valueOf(producto.getPrecio()));
        categoriaProduct.setText(producto.getCategoria());
        ubicationProduct.setText(producto.getUbicacion());
        dateProduct.setText(producto.getFecha());
        idProduct.setText(producto.getId());
        cantidadStock.setText(String.valueOf(producto.getStock()));
    }

    private boolean camposVacios() {
        return nameProduct.getText().isEmpty() ||
                idProduct.getText().isEmpty() ||
                priceProduct.getText().isEmpty() ||
                dateProduct.getText().isEmpty() ||
                categoriaProduct.getText().isEmpty() ||
                ubicationProduct.getText().isEmpty() ||
                cantidadStock.getText().isEmpty();
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlertaError(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    private void mostrarAlertaInformation(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
