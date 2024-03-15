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

public class AdministradorController {
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
        String Magally = UsuarioText.getText();
        String Magally2024 = ContraseñaText.getText();

        if (Magally.equals(admin.getUsser1()) && Magally2024.equals(admin.getPassword1())){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                callEntrar.setTitle("Incio de Sesion: \"Administrador\"");
                callEntrar.setScene(scene);
                callEntrar.show();

            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }else {
            MostraAlerta("Error","verifica tus datos");
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

        salirAdministrador();
    }
    private void MostraAlerta(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    private void salirAdministrador(){
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
                String Magally = UsuarioText.getText();
                String Magally2024 = ContraseñaText.getText();

                if (Magally.equals(admin.getUsser1()) && Magally2024.equals(admin.getPassword1())) {
                    try {
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
                        Scene scene = new Scene(fxmlLoader.load());
                        Stage newStage = new Stage();
                        newStage.setTitle("Inicio de Sesión: \"Administrador\"");
                        newStage.setScene(scene);
                        newStage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    MostraAlerta("Error", "Verifica tus datos");
                }
            }
        });
    }
}