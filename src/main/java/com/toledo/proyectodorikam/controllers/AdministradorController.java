package com.toledo.proyectodorikam.controllers;

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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorController {
    private Usuario admin = new Usuario();
    private Stage callEntrar = new Stage();

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

    @FXML
    void OnMouseClickedEntrarButton(MouseEvent event) throws IOException {
        String Magally = UsuarioText.getText();
        String Magally2024 = ContraseñaText.getText();

        if (Magally.equals(admin.getUsser1()) && Magally2024.equals(admin.getPassword1())){
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            callEntrar.setTitle("Incio de Sesion: \"Administrador\"");
            callEntrar.setScene(scene);
            callEntrar.show();
            Stage stage = (Stage) EntrarButton.getScene().getWindow();
            stage.close();
        }else {
            MostraAlerta("Error","verifica tus datos");
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    private void MostraAlerta(String title, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
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
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
                    try {
                        Scene scene = new Scene(fxmlLoader.load());
                        callEntrar.setTitle("Inicio de Sesión: \"Administrador\"");
                        callEntrar.setScene(scene);
                        callEntrar.show();
                        Stage stage = (Stage) ContraseñaText.getScene().getWindow();
                        stage.close();
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