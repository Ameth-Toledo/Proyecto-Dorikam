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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministradorController {
    private Usuario admin = new Usuario();
    private int intentos = 0;
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
    void initialize() {
        UsuarioText.setOnKeyPressed(this::handleKeyPressed);
        ContraseñaText.setOnKeyPressed(this::handleKeyPressed);
    }

    @FXML
    void OnMouseClickedEntrarButton(MouseEvent event) throws IOException {
        iniciarSesion();
    }
        @FXML
    void OnMouseClickedExitButton (MouseEvent event){
        cerrarVentana();
    }
    private void handleKeyPressed(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            if (event.getSource() == UsuarioText) {
                ContraseñaText.requestFocus();
            } else {
                iniciarSesion();
            }
        } else if (event.getCode() == KeyCode.ESCAPE) {
            cerrarVentana();
        }
    }

    private void iniciarSesion() {
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
            intentos++;
            if (intentos < 3) {
                MostrarAlerta("Error", "Verifica tus datos.\nIntento " + intentos + " de 3.");
            } else {
                MostrarAlerta("Error", "Has excedido el máximo de intentos permitidos.");
                EntrarButton.setDisable(true);
            }
        }
    }
    private void cerrarVentana(){
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
    private void MostrarAlerta (String title, String contenido){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle(title);
            alert.setHeaderText(null);
            alert.setContentText(contenido);
            alert.showAndWait();
    }
}
