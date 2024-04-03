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
    private Button ExitButton;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField PriceProduct;

    @FXML
    private TextField CategoriaProduct;

    @FXML
    private TextField UbicationProduct;

    @FXML
    private TextField DateProduct;

    @FXML
    private TextField IDProduct;

    @FXML
    private TextField cantidadStock;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private Button BuscarButton;

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProductoBuscado = NameProduct.getText();
        Producto productoEncontrado = buscarProductoPorNombre(nombreProductoBuscado);
        if (productoEncontrado != null) {
            mostrarProductoEncontrado(productoEncontrado);
        } else {
            mostrarAlertaError("Error", "El producto no existe.");
        }
    }

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        String nombreProductoBuscado = NameProduct.getText();
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
        NameProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                IDProduct.requestFocus();
            }
        });

        IDProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                PriceProduct.requestFocus();
            }
        });

        PriceProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                DateProduct.requestFocus();
            }
        });

        DateProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                CategoriaProduct.requestFocus();
            }
        });

        CategoriaProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                UbicationProduct.requestFocus();
            }
        });

        UbicationProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                cantidadStock.requestFocus();
            }
        });
        cantidadStock.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ConfirmarButton.requestFocus();
            }
        });

        ConfirmarButton.setOnKeyPressed(event -> {
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
        producto.setPrecio(Double.parseDouble(PriceProduct.getText()));
        producto.setCategoria(CategoriaProduct.getText());
        producto.setUbicacion(UbicationProduct.getText());
        producto.setFecha(DateProduct.getText());
        producto.setId(IDProduct.getText());
        producto.setStock(Integer.parseInt(cantidadStock.getText()));
    }

    private void mostrarProductoEncontrado(Producto producto) {
        NameProduct.setText(producto.getNombre());
        PriceProduct.setText(String.valueOf(producto.getPrecio()));
        CategoriaProduct.setText(producto.getCategoria());
        UbicationProduct.setText(producto.getUbicacion());
        DateProduct.setText(producto.getFecha());
        IDProduct.setText(producto.getId());
    }

    private boolean camposVacios() {
        return NameProduct.getText().isEmpty() ||
                IDProduct.getText().isEmpty() ||
                PriceProduct.getText().isEmpty() ||
                DateProduct.getText().isEmpty() ||
                CategoriaProduct.getText().isEmpty() ||
                UbicationProduct.getText().isEmpty() ||
                cantidadStock.getText().isEmpty();
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
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
