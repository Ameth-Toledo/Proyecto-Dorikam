package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class AgregarProductoController {
    private HashMap<String, Producto> productosHashMap = new HashMap<>();

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
        DateProduct.setText(LocalDate.now().toString());
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
            if (textField == PriceProduct) {
                CategoryProduct.requestFocus();
            } else {
                switchToNextTextField(textField);
            }
        }
    }

    private void handleLastTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String userInput = UbicationProduct.getText().toLowerCase().trim();
            switch (userInput) {
                case "albania alta":
                case "el carmen":
                case "albania":
                    UbicationProduct.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: " + "https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
                    break;
                case "las torres":
                case "fraccionamiento las torres":
                case "fraccionamiento":
                    UbicationProduct.setText("Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: "+"https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9");
                    break;
                default:
                    break;
            }
            confirmarProducto();
        }
    }

    private void confirmarProducto() {
        if (faltaRellenarCampo()) {
            mostrarAlertaError("Error", "Falta rellenar un campo.");
        } else {
            String nombre = NameProduct.getText();
            String id = IDProduct.getText();
            double precio = Double.parseDouble(PriceProduct.getText());
            String fecha = DateProduct.getText();
            String categoria = CategoryProduct.getText();
            String ubicacion = UbicationProduct.getText();

            Producto producto = new Producto(nombre, precio, fecha, "nulo", ubicacion, id, 0, categoria);

            productosHashMap.put(id, producto);

            limpiarCampos();

            mostrarAlertaInformation("Exito", "Producto agregado correctamente");
        }
    }

    private void limpiarCampos(){
        NameProduct.clear();
        IDProduct.clear();
        PriceProduct.clear();
        CategoryProduct.clear();
        UbicationProduct.clear();
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

    private void mostrarAlertaError(String title, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.setOnShown(event ->{
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        });
        alert.showAndWait();
    }

    private void mostrarAlertaInformation(String title, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.setOnShown(event ->{
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        });
        alert.showAndWait();
    }
}

