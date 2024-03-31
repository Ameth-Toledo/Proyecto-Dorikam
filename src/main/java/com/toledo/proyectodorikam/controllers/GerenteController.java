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

public class GerenteController {
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
        String Brenda = UsuarioText.getText();
        String Brenda2024 = ContraseñaText.getText();

        if (Brenda.equals(admin.getUsser()) && Brenda2024.equals(admin.getPassword())){
            FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            callEntrar.setTitle("Menu: \"Gerente\"");
            callEntrar.setScene(scene);
            callEntrar.show();
            Stage stage = (Stage) EntrarButton.getScene().getWindow();
            stage.close();
        }else {
            MostrarAlerta("Error","Verifica tus datos porfavor");
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    private void MostrarAlerta(String title, String contenido){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
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
                String Brenda = UsuarioText.getText();
                String Brenda2024 = ContraseñaText.getText();

                if (Brenda.equals(admin.getUsser()) && Brenda2024.equals(admin.getPassword())) {
                    FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
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
                    MostrarAlerta("Error", "Verifica tus datos");
                }
            }
        });
    }
}