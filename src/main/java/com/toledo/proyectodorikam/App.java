package com.toledo.proyectodorikam;

import com.toledo.proyectodorikam.controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class App extends Application {

    private final Map<Button, ImageView> deleteButtonMap = new HashMap<>();
    private ImageView selectedImage;
    private HBox imagesContainer;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Parent root = fxmlLoader.load();
        HomeController menuController = fxmlLoader.getController();
        menuController.init(stage);
        String[] imagePaths = {
                "/com/toledo/proyectodorikam/Imagenes/Promocion1.png",
                "/com/toledo/proyectodorikam/Imagenes/Promocion2.png",
                "/com/toledo/proyectodorikam/Imagenes/Promocion3.png",
                "/com/toledo/proyectodorikam/Imagenes/Promocion4.png",
                "/com/toledo/proyectodorikam/Imagenes/Promocion5.png"
        };
        imagesContainer = new HBox();
        imagesContainer.setSpacing(0);

        for (String imagePath : imagePaths) {
            Image image = new Image(getClass().getResourceAsStream(imagePath));
            ImageView imageView = new ImageView(image);
            imageView.setFitWidth(300);
            imageView.setPreserveRatio(true);
            imageView.setOnMouseClicked(event -> {
                if (selectedImage != null) {
                    selectedImage.setOpacity(1);
                }
                selectedImage = (ImageView) event.getSource();
                selectedImage.setOpacity(0.5);
            });
            HBox imageBox = new HBox(imageView);
            imageBox.setSpacing(10);
            imagesContainer.getChildren().add(imageBox);
        }
        Button uploadButton = new Button("Subir Imagen");
        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Seleccionar Imagen");
            File selectedFile = fileChooser.showOpenDialog(stage);
            if (selectedFile != null) {
                try {
                    Image image = new Image(new FileInputStream(selectedFile));
                    ImageView imageView = new ImageView(image);
                    imageView.setFitWidth(300);
                    imageView.setPreserveRatio(true);
                    HBox imageBox = new HBox(imageView);
                    imageBox.setSpacing(10);
                    imagesContainer.getChildren().add(imageBox);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        Button deleteButton = new Button("Eliminar");
        deleteButton.setOnAction(event -> {
            if (selectedImage != null) {
                confirmDelete(selectedImage);
            } else {
                showSelectImageAlert();
            }
        });

        HBox buttonBox = new HBox(uploadButton, deleteButton);
        buttonBox.setSpacing(10);

        VBox contentBox = new VBox(buttonBox, createScrollPane(imagesContainer));
        contentBox.setSpacing(10);

        AnchorPane anchorPane = (AnchorPane) root;
        anchorPane.getChildren().add(contentBox);
        AnchorPane.setTopAnchor(contentBox, 230.0);
        AnchorPane.setLeftAnchor(contentBox, 20.0);

        AnchorPane.setTopAnchor(buttonBox, 620.0);
        AnchorPane.setLeftAnchor(buttonBox, 10.0);

        AnchorPane.setTopAnchor(deleteButton, 620.0);
        AnchorPane.setLeftAnchor(deleteButton, 150.0);

        Scene scene = new Scene(anchorPane);
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Dorikam - Catálogo de Imágenes");
        stage.show();
    }
    private ScrollPane createScrollPane(HBox content) {
        ScrollPane scrollPane = new ScrollPane();
        scrollPane.setContent(content);
        scrollPane.setPrefSize(1200, 350);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        return scrollPane;
    }
    private void showSelectImageAlert() {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Seleccione una imagen");
        alert.setHeaderText("Por favor, seleccione una imagen para eliminar");
        alert.showAndWait();
    }
    private void confirmDelete(ImageView imageView) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmar eliminación");
        alert.setHeaderText("¿Estás seguro de que quieres eliminar esta imagen?");
        alert.setContentText("Esta acción no se puede deshacer.");

        alert.showAndWait().ifPresent(response -> {
            if (response == ButtonType.OK) {
                HBox imageBox = (HBox) imageView.getParent();
                imagesContainer.getChildren().remove(imageBox);
            }
        });
    }
    public static void main(String[] args) {
        launch(args);
    }
}