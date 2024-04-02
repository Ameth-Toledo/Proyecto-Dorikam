package com.toledo.proyectodorikam.controllers;

import com.toledo.proyectodorikam.models.Apartar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

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
    private TableView<Apartar> tablaProductosApartados;

    @FXML
    private TableColumn<Apartar, String> NameColumn;

    @FXML
    private TableColumn<Apartar, Integer> IdColumnColumn;

    @FXML
    private TableColumn<Apartar, String> FechaColumn;

    @FXML
    private TableColumn<Apartar, String> CategoriaColumn;

    @FXML
    private TableColumn<Apartar, String> UbicationColumn;

    @FXML
    private TableColumn<Apartar, Integer> CantidadColumn;

    @FXML
    private TableColumn<Apartar, Double> AbonadoColumn;

    @FXML
    private TableColumn<Apartar, Double> RestanteColumn;

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        // Implementación del botón de salida
    }

    @FXML
    void onMouseClickedVerApartadosButton(MouseEvent event) {
        List<Apartar> apartados = Apartar.getListaApartados();
        ObservableList<Apartar> observableApartados = FXCollections.observableArrayList(apartados);
        tablaProductosApartados.setItems(observableApartados);
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

        NameColumn.setCellValueFactory(cellData -> cellData.getValue().nombreProperty());
        IdColumnColumn.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        FechaColumn.setCellValueFactory(cellData -> cellData.getValue().fechaProperty());
        CategoriaColumn.setCellValueFactory(cellData -> cellData.getValue().categoriaProperty());
        UbicationColumn.setCellValueFactory(cellData -> cellData.getValue().ubicacionProperty());
        CantidadColumn.setCellValueFactory(cellData -> cellData.getValue().cantidadDeProductosProperty().asObject());
        AbonadoColumn.setCellValueFactory(cellData -> cellData.getValue().montoAbonadoProperty().asObject());
        RestanteColumn.setCellValueFactory(cellData -> cellData.getValue().montoRestanteProperty().asObject());
    }
}
