package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.net.URL;
import java.time.LocalDate;
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
    private Button Confirmar;

    @FXML
    private TextField NombreProducto;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void onMouseClickedConfirmar(MouseEvent event) {
        validarDatos();
    }

    @FXML
    void initialize() {
        setTextFieldEnterListener();
        IngresaFecha.setText(LocalDate.now().toString());
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
        Confirmar.setOnKeyPressed(event -> {
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

    private void validarDatos() {
        String nombreProducto = NombreProducto.getText();
        String idProducto = IdProducto.getText();
        String precioProductoStr = MontoAbonado.getText();
        String montoRestanteStr = MontoRestante.getText();
        String fechaCompra = IngresaFecha.getText();
        String categoria = Categoria.getText();
        if (camposVacios(nombreProducto, idProducto, precioProductoStr, montoRestanteStr, fechaCompra, categoria)) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            try {
                double precioProducto = Double.parseDouble(precioProductoStr);
                double montoRestante = Double.parseDouble(montoRestanteStr);
                mostrarAlertaError("Error", "El producto no está disponible en la lista.");
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
}
