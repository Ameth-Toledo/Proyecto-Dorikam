package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Usuario;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

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
    private TextField usuarioText;

    @FXML
    private PasswordField contrasenaText;
    private boolean capsLockActivated = false;

    @FXML
    private Button entrarButton;

    @FXML
    private Button exitButton;

    @FXML
    void initialize() {
        usuarioText.setOnKeyPressed(this::handleKeyPressed);
        contrasenaText.setOnKeyPressed(this::handleKeyPressed);

        contrasenaText.setOnKeyReleased(event -> {
            if (event.getCode().toString().equals("CAPS")) {
                capsLockActivated = !capsLockActivated;
                if (capsLockActivated) {
                    showAlertTemporal("Aviso", "Bloq Mayus Activado", 3);
                }
            }
        });
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
            if (event.getSource() == usuarioText) {
                contrasenaText.requestFocus();
            } else {
                iniciarSesion();
            }
        } else if (event.getCode() == KeyCode.ESCAPE) {
            cerrarVentana();
        }
    }

    private void iniciarSesion() {
        String adminName = usuarioText.getText();
        String adminPassword = contrasenaText.getText();

        if (adminName.equals(admin.getUsser1()) && adminPassword.equals(admin.getPassword1())) {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-administrador-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage newStage = new Stage();
                newStage.setTitle("Menu: \"Administrador\"");
                newStage.setScene(scene);
                newStage.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
                newStage.show();

                cerrarVentana();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            intentos++;
            if (intentos < 3) {
                MostrarAlerta("Error", "Verifica tus datos.\nIntento " + intentos + " de 3.");
            } else {
                MostrarAlerta("Error", "Has excedido el máximo de intentos permitidos.");
                entrarButton.setDisable(true);
            }
        }
    }
    private void cerrarVentana(){
        Stage stage = (Stage) exitButton.getScene().getWindow();
        stage.close();
    }

    private void showAlertTemporal(String title, String message, int durationSeconds) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.setOnShown(event ->{
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        });

        alert.show();
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(durationSeconds), e -> alert.close()));
        timeline.setCycleCount(1);
        timeline.play();
    }
    private void MostrarAlerta(String title, String contenido) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(contenido);
        alert.setOnShown(event ->{
            Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
            stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        });
        alert.showAndWait();
    }
}
