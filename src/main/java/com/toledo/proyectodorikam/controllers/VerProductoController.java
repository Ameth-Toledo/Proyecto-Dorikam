package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VerProductoController{

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AreteMoñoButton;

    @FXML
    private Button ExitButton;

    @FXML
    void OnMouseClickedAreteMoñoButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert AreteMoñoButton != null : "fx:id=\"AreteMoñoButton\" was not injected: check your FXML file 'ver-productos-view.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'ver-productos-view.fxml'.";

    }
}
