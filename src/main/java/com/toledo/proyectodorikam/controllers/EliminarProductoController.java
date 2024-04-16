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
import java.util.List;


import java.time.LocalDate;

public class EliminarProductoController {

    @FXML
    private Button exitButton;

    @FXML
    private TextField nameProduct;

    @FXML
    private TextField priceProduct;

    @FXML
    private TextField categoryProduct;

    @FXML
    private TextField ubicationProduct;

    @FXML
    private TextField dateProduct;

    @FXML
    private TextField idProduct;

    @FXML
    private TextField cantStock;

    @FXML
    private Button confirmarButton;

    @FXML
    private Button buscarButton;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProducto = nameProduct.getText();
        Producto productoAEliminar = buscarProductoPorNombre(nombreProducto);
        if (productoAEliminar != null) {
            Producto.eliminarProducto(productoAEliminar);
            mostrarAlertaInformation("Éxito", "Producto eliminado correctamente");
        } else {
            mostrarAlertaError("Error", "No se encontró el producto a eliminar");
        }
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

    private void mostrarProductoEncontrado(Producto producto) {
        nameProduct.setText(producto.getNombre());
        priceProduct.setText(String.valueOf(producto.getPrecio()));
        categoryProduct.setText(producto.getCategoria());
        ubicationProduct.setText(producto.getUbicacion());
        dateProduct.setText(producto.getFecha());
        idProduct.setText(producto.getId());
        cantStock.setText(String.valueOf(producto.getStock()));
    }

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = nameProduct.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProducto);
        if (productoEncontrado != null) {
            mostrarProductoEncontrado(productoEncontrado);
            mostrarAlertaInformation("Éxito", "Producto encontrado: ");
        } else {
            mostrarAlertaError("Error", "No se encontró el producto");
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
        cerrarEliminar();
    }

    public void cerrarEliminar() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void initialize() {
        dateProduct.setText(LocalDate.now().toString());
        configureEnterKey();
    }

    private void configureEnterKey() {
        nameProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                idProduct.requestFocus();
            }
        });

        idProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                priceProduct.requestFocus();
            }
        });

        priceProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                categoryProduct.requestFocus();
            }
        });

        categoryProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                ubicationProduct.requestFocus();
            }
        });

        ubicationProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String userInput = ubicationProduct.getText().toLowerCase().trim();
                switch (userInput) {
                    case "albania alta":
                    case "el carmen":
                    case "albania":
                        ubicationProduct.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                                "GoogleMaps: " + "https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
                        break;
                    case "las torres":
                    case "fraccionamiento las torres":
                    case "fraccionamiento":
                        ubicationProduct.setText("Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n " +
                                "GoogleMaps: "+"https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9");
                        break;
                }
            }
        });

        confirmarButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                if (camposVacios()) {
                    mostrarAlertaError("Error", "Por favor, complete todos los campos.");
                }
            }
        });
    }

    private boolean camposVacios() {
        return nameProduct.getText().isEmpty() ||
                idProduct.getText().isEmpty() ||
                priceProduct.getText().isEmpty() ||
                dateProduct.getText().isEmpty() ||
                categoryProduct.getText().isEmpty() ||
                ubicationProduct.getText().isEmpty() ||
                cantStock.getText().isEmpty();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
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
