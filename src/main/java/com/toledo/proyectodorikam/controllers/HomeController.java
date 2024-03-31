package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class HomeController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button GerenteButton;

    @FXML
    private Button AdministradorButton;

    @FXML
    private Button ExitButton;

    Stage callAdmin = new Stage();

    @FXML
    void OnMouseClickedAdministradorButton(MouseEvent event) throws IOException {
        abrirAdministradorView();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        salirHome();
    }

    Stage callGerente = new Stage();

    @FXML
    void OnMouseClickedGerenteButton(MouseEvent event) throws IOException {
        abrirGerenteView();
    }

    @FXML
    void initialize() {
    }

    private void salirHome() {
        ((Stage) ExitButton.getScene().getWindow()).close();
    }

    private void abrirGerenteView() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callGerente.setTitle("Inicio de Sesion: \"Gerente\"");
        callGerente.setScene(scene);
        callGerente.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callGerente.show();
    }
    private void abrirAdministradorView() throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("administrador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callAdmin.setTitle("Inicio de Sesion: \"Administrador\"");
        callAdmin.setScene(scene);
        callAdmin.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        callAdmin.show();
    }
    public void init(Stage stageRoot) {
        stageRoot.addEventHandler(KeyEvent.KEY_PRESSED, event -> {
            switch (event.getCode()) {
                case F1:
                    try {
                        abrirGerenteView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case F2:
                    try {
                        abrirAdministradorView();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
                case ESCAPE:
                    Platform.exit();
                    break;
                default:
                    break;
            }
        });
        fullScreen(stageRoot);
    }
    private void fullScreen(Stage stage) {
        stage.setFullScreen(true);
        stage.setFullScreenExitHint("");
    }
}