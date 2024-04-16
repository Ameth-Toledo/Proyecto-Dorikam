package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Imagen;
import com.toledo.proyectodorikam.models.Producto;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Optional;

import com.toledo.proyectodorikam.models.Zapato;
import com.toledo.proyectodorikam.models.Arete;

public class AgregarProductoController {

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
    private Button confirmarButton;

    @FXML
    private TextField stockProducto;

    @FXML
    private Button upLoadImagenButton;

    Stage callRegresar = new Stage();

    @FXML
    void OnMouseClickConfirmarButton(MouseEvent event) {
        String nombre = nameProduct.getText();
        String precioStr = priceProduct.getText();
        String categoria = categoryProduct.getText();
        String ubicacion = ubicationProduct.getText();
        String fecha = dateProduct.getText();
        String id = idProduct.getText();
        String stockStr = stockProducto.getText();

        if (camposVacios(nombre, precioStr, categoria, ubicacion, fecha, id, stockStr)) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            try {
                double precio = Double.parseDouble(precioStr);
                int stock = Integer.parseInt(stockStr);

                if (categoria.equalsIgnoreCase("arete")) {
                    Arete arete = new Arete(nombre, precio, categoria, ubicacion, fecha, id, stock);
                    Producto.agregarProducto(arete);
                } else {
                    Zapato zapato = new Zapato(nombre, precio, categoria, ubicacion, fecha, id, stock);
                    Producto.agregarProducto(zapato);
                }

                limpiarCampos();
                mostrarAlertaExito("Éxito", "Producto agregado correctamente");

                System.out.println("lista");
                for (Producto p : Producto.getListaProductos()) {
                    System.out.println(p.toString());
                }
            } catch (NumberFormatException e) {
                mostrarAlertaError("Error", "Ingrese valores numéricos válidos para el precio y el stock.");
            }
        }
    }
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
    void OnMouseClickedUpLoadImagenButton(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Imágenes", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(null);
        if (selectedFile != null) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Seleccione una opción");
            alert.setHeaderText(null);
            alert.setContentText("Seleccione la categoría para la imagen:");
            ButtonType zapatoButton = new ButtonType("Zapato");
            ButtonType areteButton = new ButtonType("Arete");
            ButtonType cancelButton = new ButtonType("Cancelar", ButtonBar.ButtonData.CANCEL_CLOSE);
            alert.getButtonTypes().setAll(zapatoButton, areteButton, cancelButton);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == zapatoButton) {
                Imagen.agregarImagen(selectedFile, "Zapato");
                mostrarAlertaExito("Éxito", "Imagen de zapato agregada correctamente.");
            } else if (result.isPresent() && result.get() == areteButton) {
                Imagen.agregarImagen(selectedFile, "Arete");
                mostrarAlertaExito("Éxito", "Imagen de arete agregada correctamente.");
            }
        }
    }


    @FXML
    void initialize() {
        configurarEventosTextField();
        configurarEventoEnterBotonConfirmar();
        exitButton.setOnKeyPressed(this::handleKeyPressed);
        confirmarButton.setOnKeyPressed(this::handleKeyPressed);
        dateProduct.setText(LocalDate.now().toString());
    }

    private void configurarEventosTextField() {
        nameProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        idProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        priceProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        dateProduct.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
        categoryProduct.setOnKeyPressed(this::OnKeyPressedCategoryProduct);
        ubicationProduct.setOnKeyPressed(this::handleLastTextFieldEnterKeyPressed);
        stockProducto.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
    }

    @FXML
    void OnKeyPressedCategoryProduct(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER || event.getCode() == KeyCode.TAB) {
            String userInput = categoryProduct.getText().toLowerCase().trim();
            if (!userInput.equals("arete") && !userInput.equals("zapato")) {
                mostrarAlertaError("Error", "No es posible guardar este campo, verifique que se trate de un arete o un zapato.");
                categoryProduct.clear();
            } else {
                ubicationProduct.requestFocus();
            }
        }
    }

    private void configurarEventoEnterBotonConfirmar() {
        confirmarButton.setDefaultButton(true);
    }

    private void handleTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            TextField textField = (TextField) event.getSource();
            if (textField == priceProduct) {
                categoryProduct.requestFocus();
            } else if (textField == stockProducto){
                OnMouseClickConfirmarButton(null);
            } else {
                switchToNextTextField(textField);
            }
        }
    }

    @FXML
    public void handleLastTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String userInput = ubicationProduct.getText().toLowerCase().trim();
            switch (userInput) {
                case "albania alta":
                case "el carmen":
                case "albania":
                    ubicationProduct.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
                    break;
                case "las torres":
                case "fraccionamiento las torres":
                case "fraccionamiento":
                    ubicationProduct.setText("Chiapa de Corzo 2 9, Las Torres, 29045 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: "+"https://maps.app.goo.gl/D3m1aZAk4fR3WJpR9");
                    break;
                default:
                    break;
            }
            stockProducto.requestFocus();
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

    private void limpiarCampos(){
        nameProduct.clear();
        idProduct.clear();
        priceProduct.clear();
        categoryProduct.clear();
        ubicationProduct.clear();
        stockProducto.clear();
    }

    private void switchToNextTextField(TextField currentTextField) {
        switch (currentTextField.getId()) {
            case "NameProduct":
                idProduct.requestFocus();
                break;
            case "IDProduct":
                priceProduct.requestFocus();
                break;
            case "PriceProduct":
                dateProduct.requestFocus();
                break;
            case "DateProduct":
                categoryProduct.requestFocus();
                break;
            case "CategoryProduct":
                ubicationProduct.requestFocus();
                break;
            case "UbicationProduct":
                stockProducto.requestFocus();
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
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
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
}