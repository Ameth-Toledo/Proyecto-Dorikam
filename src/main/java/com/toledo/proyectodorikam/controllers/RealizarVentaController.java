package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
    private TextField PrecioProductoTextField23;

    @FXML
    private Button ConfirmarButton;

    @FXML
    private ComboBox<String> pago;

    @FXML
    void OnMouseClickedConfirmarButton(MouseEvent event) {
        mostrarAlertaError("Error", "El producto no existe.");
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
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
}
