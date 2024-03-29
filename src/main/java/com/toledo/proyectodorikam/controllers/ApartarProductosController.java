package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.ApartarProducto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ApartarProductosController {

    private static List<ApartarProducto> lista = new ArrayList<>();

    static {
        lista.add(new ApartarProducto("Arete-manzana",  49.98,  "2022-01-01", "Churrumino", "Tuxtla",        "5B4312T1", 7));
        lista.add(new ApartarProducto("Arete-rostro",   109.88, "2022-02-01", "Chililo",    "Tuxtla",        "8F2362G1", 4));
        lista.add(new ApartarProducto("Arete-piña",     89.99,  "2022-05-23", "tapia",      "villa flores ", "BO2389D1", 8));
        lista.add(new ApartarProducto("Arete-Perla",    98.50,  "2022-03-11", "Churru",     "Tonala",        "B22089G1", 10));
        lista.add(new ApartarProducto("Arete-hongo",    120.90, "2022-02-21", "fabricio",   "tapachula",     "HV2089G1", 5));
        lista.add(new ApartarProducto("Arete-Mariposa", 50.00,  "2022-07-14", "gael",       "Huixtla",       "VO2389D2", 10));
        lista.add(new ApartarProducto("Arete-Moño",     98.50,  "2022-02-21", "ameth",      "Tuxtla",        "8F2342H2", 6));
        lista.add(new ApartarProducto("Arete-Corsal",   198.50, "2022-05-01", "sujey",      "villa flores",  "9G2323Z3", 9));
    }

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
                ApartarProducto producto = obtenerProductoPorNombre(nombreProducto);
                if (producto == null) {
                    mostrarAlertaError("Error", "El producto no está disponible en la lista.");
                } else if (montoRestante > precioProducto) {
                    mostrarAlertaError("Error", "El monto restante no puede ser mayor al monto abonado.");
                } else if (montoRestante <= 0) {
                    mostrarAlertaError("Error", "El monto restante debe ser mayor a cero.");
                } else {
                    int cantidad = 1;

                    if (cantidad <= producto.getStock()) {
                        realizarApartado(producto, cantidad, precioProducto, montoRestante);
                        mostrarAlerta("Apartado realizado", "El apartado se ha realizado correctamente.");
                    } else {
                        mostrarAlertaError("Error", "No hay suficientes productos en el stock para realizar el apartado.");
                    }
                }
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

    private void realizarApartado(ApartarProducto producto, int cantidad, double precioUnitario, double montoRestante) {
        try {
            producto.setStock(producto.getStock() - cantidad);
            producto.setMontoAbonado(producto.getMontoAbonado() + precioUnitario);
            producto.setMontoRestante(montoRestante);
            mostrarAlerta("Apartado realizado", "El apartado se ha realizado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
            mostrarAlertaError("Error", "Ocurrió un error al realizar el apartado.");
        }
    }

    private ApartarProducto obtenerProductoPorNombre(String nombre) {
        for (ApartarProducto producto : lista) {
            if (producto.getNombreProducto().equalsIgnoreCase(nombre)) {
                return producto;
            }
        }
        return null;
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