package com.toledo.proyectodorikam.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import com.toledo.proyectodorikam.models.EditarProducto; // Importa tu clase de modelo de EditarProducto

public class EditarProductoController {

    @FXML
    private Button ExitButton;

    @FXML
    private TextField NameProduct;

    @FXML
    private TextField PriceProduct;

    @FXML
    private TextField CategoriaProduct;

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
            // Obtener los valores de los campos de texto
            String nombre = NameProduct.getText();
            String id = IDProduct.getText();
            double precio = Double.parseDouble(PriceProduct.getText());
            String fecha = DateProduct.getText();
            String categoria = CategoriaProduct.getText();
            String ubicacion = UbicationProduct.getText();

            // Crear un nuevo objeto EditarProducto con los valores editados
            EditarProducto productoEditado = new EditarProducto(id, nombre, precio, categoria, ubicacion, fecha);

            // Llamar al método para guardar los cambios del producto editado en el modelo
            // Reemplaza 'guardarProductoEditado' con el método correspondiente de tu modelo
            guardarProductoEditado(productoEditado);

            // Mostrar una alerta de éxito
            mostrarAlerta("Éxito", "Los cambios han sido guardados correctamente.");

            // Cerrar la ventana de edición
            Stage stage = (Stage) ConfirmarButton.getScene().getWindow();
            stage.close();
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
        // Configurar el comportamiento de la tecla Enter para cambiar el foco entre los campos de texto
        // ...

        ConfirmarButton.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                OnMouseClickedConfirmarButton(null);
            }
        });
    }

    private boolean camposVacios() {
        return NameProduct.getText().isEmpty() ||
                IDProduct.getText().isEmpty() ||
                PriceProduct.getText().isEmpty() ||
                DateProduct.getText().isEmpty() ||
                CategoriaProduct.getText().isEmpty() ||
                UbicationProduct.getText().isEmpty();
    }

    private void mostrarAlertaError(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    private void mostrarAlerta(String titulo, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }

    // Método para guardar los cambios del producto editado en el modelo
    private void guardarProductoEditado(EditarProducto productoEditado) {
        // Aquí debes llamar al método correspondiente en tu modelo para guardar el producto editado
        // Por ejemplo:
        // modelo.guardarProductoEditado(productoEditado);
    }
}
