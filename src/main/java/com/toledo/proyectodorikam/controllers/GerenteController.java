package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;

import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GerenteController {
    private Usuario admin = new Usuario();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField UsuarioText;

    @FXML
    private PasswordField ContraseñaText;

    @FXML
    private Button EntrarButton;

    @FXML
    private Button ExitButton;

    Stage callEntrar = new Stage();

    @FXML
    void OnMouseClickedEntrarButton(MouseEvent event) throws IOException {
        String Brenda = UsuarioText.getText();
        String Brenda2024 = ContraseñaText.getText();

        if (Brenda.equals(admin.getUsser()) && Brenda2024.equals(admin.getPassword())){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                callEntrar.setTitle("Menu: \"Gerente\"");
                callEntrar.setScene(scene);
                callEntrar.show();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }else {
            MostrarAlerta("Error","Verifica tus datos porfavor");
        }
    }

    Stage callRegresar = new Stage();

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callRegresar.setTitle("Dorikam - Home");
        callRegresar.setScene(scene);
        callRegresar.show();

        salirGerente();
    }
    private void MostrarAlerta(String title, String contenido){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    private void salirGerente(){
        ((Stage) ExitButton.getScene().getWindow()).close();
    }
    @FXML
    void initialize() {
        UsuarioText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER){
                ContraseñaText.requestFocus();
            }
        });
        ContraseñaText.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                String Brenda = UsuarioText.getText();
                String Brenda2024 = ContraseñaText.getText();

                if (Brenda.equals(admin.getUsser()) && Brenda2024.equals(admin.getPassword())) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage newStage = new Stage();
                        newStage.setTitle("Inicio de Sesión: \"Administrador\"");
                        newStage.setScene(scene);
                        newStage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    MostrarAlerta("Error", "Verifica tus datos");
                }
            }
        });
    }
}