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
    private TextField Categoria;

    @FXML
    private Button ExitButton;

    @FXML
    private TextField IdProducto;

    @FXML
    private TextField IngresaFecha;

    @FXML
    private TextField MontoAbonado;

    @FXML
    private TextField MontoRestante;

    @FXML
    private TextField Ubicacion;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private TextField NombreProducto;

    @FXML
    private TextField cantidadApartar;

    @FXML
    private Button BuscarProductoButton;

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
        Stage stage = (Stage) ExitButton.getScene().getWindow();
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
        NombreProducto.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                IdProducto.requestFocus();
            }
        });
        IdProducto.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                MontoAbonado.requestFocus();
            }
        });
        MontoAbonado.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                MontoRestante.requestFocus();
            }
        });
        MontoRestante.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Categoria.requestFocus();
            }
        });
        Categoria.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                Ubicacion.requestFocus();
            }
        });
        Ubicacion.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLastTextFieldEnterKeyPressed(event);
            }
        });
        cantidadApartar.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                handleLastTextFieldEnterKeyPressed(event);
            }
        });
        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                validarDatos();
            }
        });
    }

    @FXML
    public void handleLastTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String userInput = Ubicacion.getText().toLowerCase().trim();
            switch (userInput) {
                case "albania alta":
                case "el carmen":
                case "albania":
                    Ubicacion.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: " + "https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
                    break;
                case "las torres":
                case "fraccionamiento las torres":
                case "fraccionamiento":
                    Ubicacion.setText("Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: "+"https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9");
                    break;
                default:
                    break;
            }
            validarDatos();
        }
    }

    private void buscarProducto() {
        String nombreProducto = NombreProducto.getText();
        if (nombreProducto.isEmpty()) {
            mostrarAlertaError("Error", "Ingrese un nombre de producto válido.");
            return;
        }

        for (Producto producto : Producto.getListaProductos()) {
            if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                productoEncontrado = true;
                Categoria.setText(producto.getCategoria());
                Ubicacion.setText(producto.getUbicacion());
                IngresaFecha.setText(producto.getFecha());
                IdProducto.setText(producto.getId());
                ConfirmarButton.setText("Confirmar");
                mostrarAlertaExito("Éxito", "Producto encontrado.");
                return;
            }
        }
        mostrarAlertaError("Error", "El producto no se encuentra en la lista.");
    }

    private void validarDatos() {
        String nombreProducto = NombreProducto.getText();
        String idProducto = IdProducto.getText();
        String precioProductoStr = MontoAbonado.getText();
        String montoRestanteStr = MontoRestante.getText();
        String fechaCompra = IngresaFecha.getText();
        String categoria = Categoria.getText();
        int cantidad = Integer.parseInt(cantidadApartar.getText());
        if (camposVacios(nombreProducto, idProducto, precioProductoStr, montoRestanteStr, fechaCompra, categoria)) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            try {
                Apartar apartado = new Apartar(nombreProducto, nombreProducto, Integer.parseInt(idProducto),
                        fechaCompra, categoria, Ubicacion.getText(), cantidad, Double.parseDouble(precioProductoStr),
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
