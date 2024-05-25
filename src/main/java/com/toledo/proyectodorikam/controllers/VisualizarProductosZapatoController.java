package com.toledo.proyectodorikam.controllers;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Imagen;
import com.toledo.proyectodorikam.models.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class VisualizarProductosZapatoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private ScrollPane catalogoAretes;

    @FXML
    private Button subirImagenButton;

    @FXML
    private Button eliminarImagenButton;

    @FXML
    private TextField nombreProduct;

    @FXML
    private Button buscarButton;

    @FXML
    private TableView<Producto> productosTable;

    @FXML
    private TableColumn<Producto, String> nombre;

    @FXML
    private TableColumn<Producto, Double> precio;

    @FXML
    private TableColumn<Producto, String> categoria;

    @FXML
    private TableColumn<Producto, String> ubicacion;

    @FXML
    private TableColumn<Producto, String> fecha;

    @FXML
    private TableColumn<Producto, String> id;

    @FXML
    private TableColumn<Producto, Integer> stockColum;

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
                                Imagen.eliminarImagen(imageView.getImage().getUrl(), "Zapato");
                                flowPane.getChildren().remove(imageView);
                            }
                        });
                    });
                }
            }
        }
    }

    Stage callExit = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Ver Productos\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
        cerrarVentana();
    }

    public void cerrarVentana() {
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void OnMouseClickedSubirImagenButton(MouseEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Seleccionar imagen");
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("Archivos de imagen", "*.png", "*.jpg", "*.gif")
        );
        File selectedFile = fileChooser.showOpenDialog(subirImagenButton.getScene().getWindow());
        if (selectedFile != null) {
            Image image = new Image(selectedFile.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300);
            imageView.setFitHeight(350);

            flowPane.getChildren().add(imageView);
            Imagen.agregarImagen(selectedFile, "Zapato");
        }
    }

    @FXML
    void OnMouseClickedBuscarButton(MouseEvent event) {
        String nombreProducto = nombreProduct.getText();
        if (!nombreProducto.isEmpty()) {
            ObservableList<Producto> productosData = FXCollections.observableArrayList();
            for (Producto producto : Producto.getListaProductos()) {
                if (producto.getNombre().equalsIgnoreCase(nombreProducto)) {
                    productosData.add(producto);
                }
            }
            productosTable.setItems(productosData);
        } else {
            productosTable.setItems(FXCollections.observableArrayList(Producto.getListaProductos()));
        }
    }

    @FXML
    void initialize() {
        flowPane = new FlowPane();
        flowPane.setHgap(0);
        flowPane.setVgap(0);
        flowPane.setOrientation(Orientation.VERTICAL);
        flowPane.setColumnHalignment(HPos.LEFT);
        catalogoAretes.setContent(flowPane);

        catalogoAretes.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        catalogoAretes.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);

        for (File imagen : Imagen.getListaZapatos()) {
            Image image = new Image(imagen.toURI().toString());
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300);
            imageView.setFitHeight(350);
            flowPane.getChildren().add(imageView);
        }

        nombre.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        precio.setCellValueFactory(cellData -> cellData.getValue().precioProperty().asObject());
        categoria.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        ubicacion.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        fecha.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        id.setCellValueFactory(cellData -> cellData.getValue().idProperty());
        stockColum.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
    }
}
