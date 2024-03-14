package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("administrador-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callAdmin.setTitle("Inicio de Sesion: \"Administrador\"");
        callAdmin.setScene(scene);
        callAdmin.show();

        salirReporte();
    }
    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    Stage callGerente = new Stage();

    @FXML
    void OnMouseClickedGerenteButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callGerente.setTitle("Incio de Sesion: \"Gerente\"");
        callGerente.setScene(scene);
        callGerente.show();

        salirReporte();
    }

    @FXML
    void initialize() {
    }
    private void salirReporte(){
        ((Stage) ExitButton.getScene().getWindow()).close();
    }

    public void init(Stage stageRoot) {
    }
}
