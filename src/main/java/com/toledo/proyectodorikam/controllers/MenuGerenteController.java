package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MenuGerenteController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button AgregarButton;

    @FXML
    private Button VerProductos;

    @FXML
    private Button UbicarButton;

    @FXML
    private Button EditarButton;

    @FXML
    private Button VentasButton;

    @FXML
    private Button ContarButton;

    @FXML
    private Button EliminarButton;

    @FXML
    void OnMouseClickedAgregarButton(MouseEvent event) throws IOException {
        abrirAgregarButton();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) throws IOException {
        abrirContarButton();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedEditarButton(MouseEvent event) throws IOException {
        abrirEditarButton();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedEliminarButton(MouseEvent event) throws IOException {
        abrirEliminarButton();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    @FXML void OnMouseClickedUbicarButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedVentasButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        abrirVerButton();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedVerReportesButton(MouseEvent event) throws IOException {
        abrirReportesButton();
        cerrarVentana();
    }

    Stage callAgregar = new Stage();

    private void abrirAgregarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("agregar-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callAgregar.setTitle("Agregar Productos");
        callAgregar.setScene(scene);
        callAgregar.show();
        cerrarVentana();
    }

    Stage callContar = new Stage();

    private void abrirContarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("gerente-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callContar.setTitle("Inicio de Sesion: \"Gerente\"");
        callContar.setScene(scene);
        callContar.show();
        cerrarVentana();
    }

    Stage callEditar = new Stage();
    private void abrirEditarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("editar-producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEditar.setTitle("Menu: \"Ver Productos\"");
        callEditar.setScene(scene);
        callEditar.show();
        cerrarVentana();
    }

    Stage callEliminar = new Stage();
    private void abrirEliminarButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("eliminar-producto-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEliminar.setTitle("Menu: \"eliminar Productos\"");
        callEliminar.setScene(scene);
        callEliminar.show();
        cerrarVentana();
    }

    Stage callVer = new Stage();
    private void abrirVerButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("tipo-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();
        cerrarVentana();
    }

    private void abrirVentasButton() throws IOException {
        cerrarVentana();
    }

    private void abrirReportesButton() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-reportes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = new Stage();
        stage.setTitle("Ver Reportes");
        stage.setScene(scene);
        stage.show();
        cerrarVentana();
    }

    private void abrirUbicarButton() throws IOException {
        cerrarVentana();
    }

    private void abrirContarProductos() throws IOException {
        cerrarVentana();
    }
    private void cerrarVentana() throws IOException {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    void initialize() {
        Platform.runLater(() -> {
            Scene scene = ExitButton.getScene();
            if (scene != null) {
                scene.setOnKeyPressed(event -> {
                    switch (event.getCode()) {
                        case F1:
                            try {
                                abrirAgregarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F2:
                            try {
                                abrirEditarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F3:
                            try {
                                abrirEliminarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F4:
                            try {
                                abrirVerButton();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        case F5:
                            try {
                                abrirVentasButton();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        case F6:
                            try {
                                abrirReportesButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F7:
                            try {
                                abrirUbicarButton();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F8:
                            try {
                                abrirContarProductos();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F9:
                            showAlert("Ayuda",
                                    "𝑭𝟏:    𝑨𝒈𝒓𝒆𝒈𝒂𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔\n" +
                                            "𝑭𝟐:    𝑬𝒅𝒊𝒕𝒂𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔\n" +
                                            "𝑭𝟑:    𝑬𝒍𝒊𝒎𝒊𝒏𝒂𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔\n" +
                                            "𝑭𝟒:    𝑽𝒆𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔\n" +
                                            "𝑭𝟓:    𝑽𝒆𝒓 𝑽𝒆𝒏𝒕𝒂𝒔\n" +
                                            "𝑭𝟔:    𝑽𝒆𝒓 𝑹𝒆𝒑𝒐𝒓𝒕𝒆𝒔\n" +
                                            "𝑭𝟕:    𝑼𝒃𝒊𝒄𝒂𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔\n" +
                                            "𝑭𝟖:    𝑪𝒐𝒏𝒕𝒂𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔\n" +
                                            "𝑬𝑺𝑪:  𝑺𝒂𝒍𝒊𝒓");
                            break;
                        case ESCAPE:
                            try {
                                cerrarVentana();
                            } catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        default:
                            break;
                    }
                });
            }
        });
    }
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
        stage.getIcons().add(new Image(getClass().getResourceAsStream("/com/toledo/proyectodorikam/Imagenes/Logo.png")));
        alert.showAndWait();
    }
}
