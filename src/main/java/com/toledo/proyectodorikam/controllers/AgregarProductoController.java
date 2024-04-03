package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Imagenes;
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
    private TextField stockProducto;

    @FXML
    private Button UpLoadImagenButton;

    Stage callRegresar = new Stage();

    @FXML
    void OnMouseClickConfirmarButton(MouseEvent event) {
        String nombre = NameProduct.getText();
        double precio = Double.parseDouble(PriceProduct.getText());
        String categoria = CategoryProduct.getText();
        String ubicacion = UbicationProduct.getText();
        String fecha = DateProduct.getText();
        String id = IDProduct.getText();
        int stock = Integer.parseInt(stockProducto.getText());

        Producto producto = new Producto(nombre, precio, categoria, ubicacion, fecha, id, stock);
        Producto.agregarProducto(producto);

        limpiarCampos();
        mostrarAlertaInformation("Éxito", "Producto agregado correctamente");

        System.out.println("lista");
        for (Producto p : Producto.getListaProductos()) {
            System.out.println(p.toString()
            );
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
                Imagenes.agregarImagen(selectedFile, "Zapato");
                mostrarAlertaExito("Éxito", "Imagen de zapato agregada correctamente.");
            } else if (result.isPresent() && result.get() == areteButton) {
                Imagenes.agregarImagen(selectedFile, "Arete");
                mostrarAlertaExito("Éxito", "Imagen de arete agregada correctamente.");
            }
        }
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
        stockProducto.setOnKeyPressed(this::handleTextFieldEnterKeyPressed);
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

    @FXML
    public void handleLastTextFieldEnterKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String userInput = UbicationProduct.getText().toLowerCase().trim();
            switch (userInput) {
                case "albania alta":
                case "el carmen":
                case "albania":
                    UbicationProduct.setText("12 de Noviembre, 29016 Tuxtla Gutiérrez, Chis. \n " +
                            "GoogleMaps: https://maps.app.goo.gl/G1T5vDY56ZJkVoqCA");
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
            validarDatos();
        }
    }

    private void validarDatos() {
        String nombreProducto = NameProduct.getText();
        String idProducto = IDProduct.getText();
        String fechaCompra = DateProduct.getText();
        String categoria = CategoryProduct.getText();
        String precioProductoStr = PriceProduct.getText();
        String ubication = UbicationProduct.getText();
        String stock = stockProducto.getText();

        if (camposVacios(nombreProducto, idProducto, precioProductoStr, fechaCompra, categoria, ubication)) {
            mostrarAlertaError("Error", "Por favor, complete todos los campos.");
        } else {
            try {
                double precioProducto = Double.parseDouble(precioProductoStr);
                Producto agregar = new Producto(nombreProducto, precioProducto, categoria, ubication, fechaCompra, idProducto, Integer.parseInt(stock));
                Producto.agregarProducto(agregar);
                mostrarAlertaExito("Éxito", "Producto agregado con éxito.");
            } catch (NumberFormatException e) {
                mostrarAlertaError("Error", "Ingrese un valor numérico válido para el precio o stock porfavor.");
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

    private void limpiarCampos(){
        NameProduct.clear();
        IDProduct.clear();
        PriceProduct.clear();
        CategoryProduct.clear();
        UbicationProduct.clear();
        stockProducto.clear();
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
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
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