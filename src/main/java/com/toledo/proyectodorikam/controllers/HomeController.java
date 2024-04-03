package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import com.toledo.proyectodorikam.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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

    @FXML
    private Label clockLabel;

    @FXML
    private Label dateLabel;


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
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    actualizarHora();
                });
            }
        }, 0, 1000);
        updateDateLabel();
    }

    private void actualizarHora() {
        LocalTime horaActual = LocalTime.now();
        String horaFormateada = String.format("%02d:%02d:%02d", horaActual.getHour(), horaActual.getMinute(), horaActual.getSecond());
        clockLabel.setText(horaFormateada);
    }

    private void updateDateLabel() {
        LocalDate date = LocalDate.now();
        String formattedDate = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        dateLabel.setText(formattedDate);
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
        //fullScreen(stageRoot);
    }
    //private void fullScreen(Stage stage) {
        //stage.setFullScreen(true);
        //stage.setFullScreenExitHint("");
    //}
}