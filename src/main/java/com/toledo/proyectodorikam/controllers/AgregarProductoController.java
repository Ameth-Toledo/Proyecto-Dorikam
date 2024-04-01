package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
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
import java.time.LocalDate;

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
            limpiarCampos();

            mostrarAlertaInformation("Éxito", "Producto agregado correctamente");
        }
    }

    private void limpiarCampos(){
        NameProduct.clear();
        IDProduct.clear();
        PriceProduct.clear();
        CategoryProduct.clear();
        UbicationProduct.clear();
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