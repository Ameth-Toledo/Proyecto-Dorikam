package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class VerEntregadosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<?, ?> ContenidoColumn;

    @FXML
    private Button DescargarButton;

    @FXML
    private Button ExitButton;

    @FXML
    private TableColumn<?, ?> FechaColumn;

    @FXML
    private TableView<?> TableReportes;

    @FXML
    private TableColumn<?, ?> TituloColumn;

    @FXML
    private Button verReportes;

    @FXML
    void OnMouseClickedDescargarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }

}
