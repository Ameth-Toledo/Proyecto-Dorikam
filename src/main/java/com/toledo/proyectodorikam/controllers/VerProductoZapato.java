package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class VerProductoZapato {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button AreteMoñoButton;

    @FXML
    private Button ExitButton;

    @FXML
    private Button AreteRostroButton;

    @FXML
    private Button AreteManzanaButton;

    @FXML
    private Button AretePiñaButton;

    @FXML
    private Button AreteCorsalButton;

    @FXML
    private Button AretePerlaButton;

    @FXML
    private Button AreteHongoButton;

    @FXML
    private Button AreteMariposaButton;

    @FXML
    private ListView<?> VerInformacionProducto;

    @FXML
    void OnMouseClickedAreteCorsalButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAreteHongoButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAreteManzanaButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAreteMariposaButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAreteMoñoButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAretePerlaButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAretePiñaButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedAreteRostroButton(MouseEvent event) {
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
    }
}
