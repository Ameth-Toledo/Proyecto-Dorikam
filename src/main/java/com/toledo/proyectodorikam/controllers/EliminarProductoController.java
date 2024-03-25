package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class EliminarProductoController {

    @FXML
    private Button ExitButton;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField PriceProduct;

    @FXML
    private TextField CategoryProduct;

    @FXML
    private TextField UbicationProduct;

    @FXML
    private TextField DateProduct;

    @FXML
    private TextField IDProduct;

    @FXML
    private Button ConfirmarButton;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        if (camposVacios()) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            // fredy Aquí va la lógica para el botón Confirmar
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
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
                CategoryProduct.requestFocus();
            }
        });

        CategoryProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                UbicationProduct.requestFocus();
            }
        });

        UbicationProduct.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                ConfirmarButton.requestFocus();
            }
        });

        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                if (camposVacios()) {
                    mostrarAlertaError("Error", "Por favor, complete todos los campos.");
                } else {
                    // Aquí igual va la lógica para el botón Confirmar
                }
            }
        });
    }

    private boolean camposVacios() {
        return NameProduct.getText().isEmpty() ||
                IDProduct.getText().isEmpty() ||
                PriceProduct.getText().isEmpty() ||
                DateProduct.getText().isEmpty() ||
                CategoryProduct.getText().isEmpty() ||
                UbicationProduct.getText().isEmpty();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
