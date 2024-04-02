package com.toledo.proyectodorikam.controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.models.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.stage.Stage;

public class VerProductoZapatoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private ListView<String> VerInformacionProducto;

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

    @FXML
    private TableView<Producto> ProductosTable;

    @FXML
    private TableColumn<Producto, String> Nombre;

    @FXML
    private TableColumn<Producto, Double> Precio;

    @FXML
    private TableColumn<Producto, String> Categoria;

    @FXML
    private TableColumn<Producto, String> Ubicacion;

    @FXML
    private TableColumn<Producto, String> Fecha;

    @FXML
    private TableColumn<Producto, String> ID;

    @FXML
    private TableColumn<Producto, Integer> StockColum;


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
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnMouseClickedSubirImagenButton(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(SubirImagenButton.getScene().getWindow());
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300);
            imageView.setFitHeight(350);

            flowPane.getChildren().add(imageView);
        }
    }
    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = NombreProducto.getText();
        if (!nombreProducto.isEmpty()) {
            ObservableList<Producto> productosData = FXCollections.observableArrayList();
            for (Producto producto : Producto.getListaProductos()) {
                if (producto.getNombre().equals(nombreProducto)) {
                    productosData.add(producto);
                }
            }
            ProductosTable.setItems(productosData);
        } else {
            ProductosTable.setItems(FXCollections.observableArrayList(Producto.getListaProductos()));
        }
    }


    @FXML
    void initialize() {
        flowPane = new FlowPane();
        flowPane.setHgap(0);
        flowPane.setVgap(0);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setColumnHalignment(HPos.LEFT);
        CatalogoAretes.setContent(flowPane);

        Nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        Precio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        Categoria.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        Ubicacion.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        Fecha.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        ID.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        StockColum.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
    }
}