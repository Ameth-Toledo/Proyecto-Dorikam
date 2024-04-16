package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class TipoProductoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitButton;

    @FXML
    private Button areteButton;

    @FXML
    private Button zapatosButton;

    Stage callArete = new Stage();
    @FXML
    void OnMouseClickedAreteButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callArete.setTitle("Menu: \"Ver Productos\"");
        callArete.setScene(scene);
        callArete.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callArete.show();

        salirTipoProducto();
    }

    Stage callExit = new Stage();
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callExit.setTitle("Menu: \"Ver Productos\"");
        callExit.setScene(scene);
        callExit.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callExit.show();
        salirTipoProducto();
    }

    Stage callZapato = new Stage();

    @FXML
    void OnMouseClickedZapatosButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-productos-zapatos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callZapato.setTitle("Menu: \"Ver Productos\"");
        callZapato.setScene(scene);
        callZapato.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callZapato.show();

        salirTipoProducto();
    }
    private void salirTipoProducto(){
        ((Stage) exitButton.getScene().getWindow()).close();
    }

    @FXML
    void initialize() {
    }
}
