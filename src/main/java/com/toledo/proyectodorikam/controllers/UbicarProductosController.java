package com.toledo.proyectodorikam.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class UbicarProductosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> Tabla;

    @FXML
    private TableColumn<?, ?> cantidad;

    @FXML
    private TableColumn<?, ?> entrega;

    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> precio;

    @FXML
    private TableColumn<?, ?> producto;

    @FXML
    private Button verReportes;

    @FXML
    private Button verReportes1;

    @FXML
    private Button verReportes3;

    @FXML
    private Button verReportes31;

    @FXML
    void onMouseClickedVerReportes(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert Tabla != null : "fx:id=\"Tabla\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert cantidad != null : "fx:id=\"cantidad\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert entrega != null : "fx:id=\"entrega\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert id != null : "fx:id=\"id\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert precio != null : "fx:id=\"precio\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert producto != null : "fx:id=\"producto\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert verReportes != null : "fx:id=\"verReportes\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert verReportes1 != null : "fx:id=\"verReportes1\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert verReportes3 != null : "fx:id=\"verReportes3\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";
        assert verReportes31 != null : "fx:id=\"verReportes31\" was not injected: check your FXML file 'ubicar-productos-view.fxml'.";

    }

}
