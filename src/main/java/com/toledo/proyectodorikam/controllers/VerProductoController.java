package com.toledo.proyectodorikam.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class VerProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private ListView<?> VerInformacionProducto;

    @FXML
    private ScrollPane CatalogoAretes;

    @FXML
    private Button SubirImagenButton;

    @FXML
    private Button EliminarImagenButton;

    @FXML
    private TextField NombreProducto;

    @FXML
    private Button BuscarButton;

    private FlowPane flowPane;

    @FXML
    void OnMouseClickedEliminarImagenButton(MouseEvent event) {
        if (flowPane == null || flowPane.getChildren().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("No hay imágenes para eliminar.");
            alert.showAndWait();
        } else {
            Alert selectImageAlert = new Alert(Alert.AlertType.INFORMATION);
            selectImageAlert.setTitle("Información");
            selectImageAlert.setHeaderText(null);
            selectImageAlert.setContentText("Selecciona una imagen para eliminar.");
            selectImageAlert.showAndWait();

            for (Node node : flowPane.getChildren()) {
                if (node instanceof ImageView) {
                    ImageView imageView = (ImageView) node;
                    imageView.setOnMouseClicked(e -> {
                        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
                        confirmation.setTitle("Confirmación");
                        confirmation.setHeaderText(null);
                        confirmation.setContentText("¿Estás seguro de eliminar esta imagen?");
                        confirmation.getButtonTypes().setAll(ButtonType.OK, ButtonType.CANCEL);
                        confirmation.showAndWait().ifPresent(response -> {
                            if (response == ButtonType.OK) {
                                flowPane.getChildren().remove(imageView);
                            }
                        });
                    });
                }
            }
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        // Implementa aquí la lógica para cerrar la ventana si es necesario
    }

    @FXML
    void OnMouseClickedSubirImagenButton(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(SubirImagenButton.getScene().getWindow());
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300);
            imageView.setFitHeight(300);
            flowPane.getChildren().add(imageView);
        }
    }

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        flowPane = new FlowPane();
        flowPane.setHgap(10);
        flowPane.setVgap(10);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setColumnHalignment(HPos.LEFT);
        CatalogoAretes.setContent(flowPane);
    }
}