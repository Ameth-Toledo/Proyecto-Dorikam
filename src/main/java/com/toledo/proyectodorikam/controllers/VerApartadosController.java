package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class VerApartadosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button VerApartadosButton;

    @FXML
    private TableView<?> tablaProductosApartados;

    @FXML
    private TableColumn<?, ?> NameColumn;

    @FXML
    private TableColumn<?, ?> IdColumnColumn;

    @FXML
    private TableColumn<?, ?> FechaColumn;

    @FXML
    private TableColumn<?, ?> CategoriaColumn;

    @FXML
    private TableColumn<?, ?> UbicationColumn;

    @FXML
    private TableColumn<?, ?> CantidadColumn;

    @FXML
    private TableColumn<?, ?> AbonadoColumn;

    @FXML
    private TableColumn<?, ?> RestanteColumn;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {

    }

    @FXML
    void onMouseClickedVerApartadosButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert VerApartadosButton != null : "fx:id=\"VerApartadosButton\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert tablaProductosApartados != null : "fx:id=\"tablaProductosApartados\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert NameColumn != null : "fx:id=\"NameColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert IdColumnColumn != null : "fx:id=\"IdColumnColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert FechaColumn != null : "fx:id=\"FechaColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert CategoriaColumn != null : "fx:id=\"CategoriaColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert UbicationColumn != null : "fx:id=\"UbicationColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert CantidadColumn != null : "fx:id=\"CantidadColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert AbonadoColumn != null : "fx:id=\"AbonadoColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";
        assert RestanteColumn != null : "fx:id=\"RestanteColumn\" was not injected: check your FXML file 'ver-apartados-view.fxml'.";

    }
}
