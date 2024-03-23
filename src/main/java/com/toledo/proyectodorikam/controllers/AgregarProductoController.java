package com.toledo.proyectodorikam.controllers;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AgregarProductoController {

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
        confirmarProducto();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    @FXML
    void initialize() {
        configurarEventosTextField();
        configurarEventoEnterBotonConfirmar();
        ExitButton.setOnKeyPressed(this::handleKeyPressed);
        ConfirmarButton.setOnKeyPressed(this::handleKeyPressed);
    }

    private void configurarEventosTextField() {
        NameProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        IDProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        PriceProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        DateProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        CategoryProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        UbicationProduct.setOnKeyPressed(this::handleLastTextFieldEnterKeyPressed);
    }

    private void configurarEventoEnterBotonConfirmar() {
        ConfirmarButton.setDefaultButton(true);
    }

    private void handleTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            TextField textField = (TextField) event.getSource();
            switchToNextTextField(textField);
        }
    }

    private void handleLastTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            confirmarProducto();
        }
    }

    private void confirmarProducto() {
        if (faltaRellenarCampo()) {
            mostrarAlerta("Error", "Falta rellenar un campo.");
        } else {
        }
    }

    private boolean faltaRellenarCampo() {
        return NameProduct.getText().isEmpty() || IDProduct.getText().isEmpty() ||
                PriceProduct.getText().isEmpty() || DateProduct.getText().isEmpty() ||
                CategoryProduct.getText().isEmpty() || UbicationProduct.getText().isEmpty();
    }

    private void switchToNextTextField(TextField currentTextField) {
        switch (currentTextField.getId()) {
            case "NameProduct":
                IDProduct.requestFocus();
                break;
            case "IDProduct":
                PriceProduct.requestFocus();
                break;
            case "PriceProduct":
                DateProduct.requestFocus();
                break;
            case "DateProduct":
                CategoryProduct.requestFocus();
                break;
            case "CategoryProduct":
                UbicationProduct.requestFocus();
                break;
        }
    }

    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ESCAPE) {
            try {
                cerrarVentana();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    private void mostrarAlerta(String title, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
}
