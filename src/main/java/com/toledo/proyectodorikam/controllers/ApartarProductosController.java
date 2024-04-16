package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Apartar;
import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApartarProductosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField categoriaProducto;

    @FXML
    private Button exitButton;

    @FXML
    private TextField idProduct;

    @FXML
    private TextField ingresaFecha;

    @FXML
    private TextField montoAbonado;

    @FXML
    private TextField montoRestante;

    @FXML
    private TextField ubicacionProduct;

    @FXML
    private Button confirmarButton;

    @FXML
    private TextField nombreProduct;

    @FXML
    private TextField cantidadApartar;

    @FXML
    private Button buscarProductoButton;

    @FXML
    void OnMouseClickedBuscarProductoButton(MouseEvent event) {
        buscarProducto();
    }

    private Apartar apartar;
    private boolean productoEncontrado = false;

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
    void onMouseClickedConfirmarButton(MouseEvent event) {
        if (productoEncontrado) {
            validarDatos();
        } else {
            buscarProducto();
        }
    }

    private void setTextFieldEnterListener() {
        nombreProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                idProduct.requestFocus();
            }
        });
        idProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                montoAbonado.requestFocus();
            }
        });
        montoAbonado.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                montoRestante.requestFocus();
            }
        });
        montoRestante.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                categoriaProducto.requestFocus();
            }
        });
        categoriaProducto.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                ubicacionProduct.requestFocus();
            }
        });
        ubicacionProduct.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLastTextFieldEnterKeyPressed(event);
            }
        });
        cantidadApartar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLastTextFieldEnterKeyPressed(event);
            }
        });
        confirmarButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                validarDatos();
            }
        });
    }

    @FXML
    public void handleLastTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String userInput = ubicacionProduct.getText().toLowerCase().trim();
            switch (userInput) {
                case "albania alta":
                case "el carmen":
                case "albania":
                    ubicacionProduct.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: " + "https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
                    break;
                case "las torres":
                case "fraccionamiento las torres":
                case "fraccionamiento":
                    ubicacionProduct.setText("Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: "+"https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9");
                    break;
                default:
                    break;
            }
            validarDatos();
        }
    }

    private void buscarProducto() {
        String nombreProducto = nombreProduct.getText();
        if (nombreProducto.isEmpty()) {
            mostrarAlertaError("Error", "Ingrese un nombre de producto válido.");
            return;
        }

        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoEncontrado = true;
                categoriaProducto.setText(producto.getCategoria());
                ubicacionProduct.setText(producto.getUbicacion());
                ingresaFecha.setText(producto.getFecha());
                idProduct.setText(producto.getId());
                confirmarButton.setText("Confirmar");
                double precioProducto = producto.getPrecio();
                mostrarAlertaExito("Éxito", "Producto encontrado. El costo del producto es de: $" + precioProducto);
                return;
            }
        }
        mostrarAlertaError("Error", "El producto no se encuentra en la lista.");
    }

    private void validarDatos() {
        String nombreProducto = nombreProduct.getText();
        String idProducto = idProduct.getText();
        String precioProductoStr = montoAbonado.getText();
        String montoRestanteStr = montoRestante.getText();
        String fechaCompra = ingresaFecha.getText();
        String categoria = categoriaProducto.getText();
        int cantidad = Integer.parseInt(cantidadApartar.getText());
        if (camposVacios(nombreProducto, idProducto, precioProductoStr, montoRestanteStr, fechaCompra, categoria)) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            try {
                Apartar apartado = new Apartar(nombreProducto, nombreProducto, Integer.parseInt(idProducto),
                        fechaCompra, categoria, ubicacionProduct.getText(), cantidad, Double.parseDouble(precioProductoStr),
                        Double.parseDouble(montoRestanteStr));
                Apartar.agregarApartado(apartado);
                mostrarAlertaExito("Éxito", "Producto apartado con éxito.");
            } catch (NumberFormatException e) {
                mostrarAlertaError("Error", "Ingrese valores numéricos válidos para el precio y el monto restante.");
            }
        }
    }

    private boolean camposVacios(String... campos) {
        for (String campo : campos) {
            if (campo.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlertaExito(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    @FXML
    void initialize() {
        setTextFieldEnterListener();
    }

}
