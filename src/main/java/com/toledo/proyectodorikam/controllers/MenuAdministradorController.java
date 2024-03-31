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

public class MenuAdministradorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button ExitButton;

    @FXML
    private Button RealizarButton;

    @FXML
    private Button VerProductos;

    @FXML
    private Button UbicarButton;

    @FXML
    private Button CancelarButton;

    @FXML
    private Button ReportesButton;

    @FXML
    private Button ContarButton;

    @FXML
    private Button EntregasButton;

    @FXML
    void OnMouseClickedCancelarButton(MouseEvent event) {

    }

    @FXML
    void OnMouseClickedContarButton(MouseEvent event) throws IOException {
        abrirContar();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedEntregasButton(MouseEvent event) throws IOException {
        abrirEntregas();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) throws IOException {
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedRealizarButton(MouseEvent event) throws IOException {
        abrirRealizar();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedReportesButton(MouseEvent event) throws IOException {
        abrirGenerar();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedUbicarButton(MouseEvent event) throws IOException {
        abrirUbicar();
        cerrarVentana();
    }

    @FXML
    void OnMouseClickedVerProductos(MouseEvent event) throws IOException {
        abrirVerProductos();
        cerrarVentana();
    }

    @FXML
    void onMouseClickedApartado(MouseEvent event) throws IOException {
        abrirApartar();
        cerrarVentana();
    }

    Stage callRealizar = new Stage();

    private void abrirRealizar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("realizar-venta-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callRealizar.setTitle("Menu: \"Ver Productos\"");
        callRealizar.setScene(scene);
        callRealizar.show();
        cerrarVentana();
    }

    Stage callCancelar = new Stage();
    private void abrirCancelar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("falta-interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callCancelar.setTitle("\"Cancelar\"");
        callCancelar.setScene(scene);
        callCancelar.show();
        cerrarVentana();
    }

    Stage callVer = new Stage();

    private void abrirVerProductos() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ver-productos-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callVer.setTitle("Menu: \"Ver Productos\"");
        callVer.setScene(scene);
        callVer.show();
        cerrarVentana();
    }

    Stage callEntregas = new Stage();
    private void abrirEntregas() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("falta-intefaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callEntregas.setTitle("Entregas de Productos");
        callEntregas.setScene(scene);
        callEntregas.show();
        cerrarVentana();
    }

    Stage callGenerar = new Stage();

    private void abrirGenerar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("generar-reportes-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callGenerar.setTitle("Generar Reportes");
        callGenerar.setScene(scene);
        callGenerar.show();

        cerrarVentana();
    }

    Stage callApartar = new Stage();

    private void abrirApartar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("apartar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callApartar.setTitle("\"Apartar Productos\"");
        callApartar.setScene(scene);
        callApartar.show();

        cerrarVentana();
    }

    Stage callUbicar = new Stage();
    private void abrirUbicar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("falta-interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callUbicar.setTitle("\"Ubicar Productos\"");
        callUbicar.setScene(scene);
        callUbicar.show();
        cerrarVentana();
    }

    Stage callContar = new Stage();
    private void abrirContar() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("apartar-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        callContar.setTitle("Menu: \"Ver Productos\"");
        callContar.setScene(scene);
        callContar.show();
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
                                abrirRealizar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F2:
                            try {
                                abrirCancelar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F3:
                            try {
                                abrirVerProductos();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F4:
                            try {
                                abrirEntregas();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F5:
                            try {
                                abrirGenerar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F6:
                            try {
                                abrirApartar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F7:
                            try {
                                abrirUbicar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F8:
                            try {
                                abrirContar();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case F9:
                            showAlert("Ayuda",
                                    "𝑭𝟏:   𝑹𝒆𝒂𝒍𝒊𝒛𝒂𝒓 𝑽𝒆𝒏𝒕𝒂 \n" +
                                            "𝑭𝟐:   𝑪𝒂𝒏𝒄𝒆𝒍𝒂𝒓 𝑽𝒆𝒏𝒕𝒂 \n" +
                                            "𝑭𝟑:   𝑽𝒆𝒓 𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔 \n" +
                                            "𝑭𝟒:   𝑬𝒏𝒕𝒓𝒆𝒈𝒂𝒔 \n" +
                                            "𝑭𝟓:   𝑮𝒆𝒏𝒆𝒓𝒂𝒓 𝑹𝒆𝒑𝒐𝒓𝒕𝒆𝒔 \n" +
                                            "𝑭𝟔:   𝑨𝒑𝒂𝒓𝒕𝒂𝒓𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔 \n" +
                                            "𝑭𝟕:   𝑼𝒃𝒊𝒄𝒂𝒓𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔 \n" +
                                            "𝑭𝟖:   𝑪𝒐𝒏𝒕𝒂𝒓𝑷𝒓𝒐𝒅𝒖𝒄𝒕𝒐𝒔 \n" +
                                            "𝑬𝑺𝑪:  𝑺𝒂𝒍𝒊𝒓");
                            break;
                        case ESCAPE:
                            try {
                                cerrarVentana();
                            } catch (IOException e) {
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