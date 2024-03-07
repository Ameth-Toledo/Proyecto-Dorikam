package com.toledo.proyectodorikam.controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.toledo.proyectodorikam.App;
import com.toledo.proyectodorikam.models.Usuario;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GerenteController {
    private Usuario admin = new Usuario();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField UsuarioText;

    @FXML
    private PasswordField ContraseñaText;

    @FXML
    private Button EntrarButton;

    @FXML
    private Button ExitButton;

    Stage callEntrar = new Stage();

    @FXML
    void OnMouseClickedEntrarButton(MouseEvent event) throws IOException {
        String Brenda = UsuarioText.getText();
        String Brenda2024 = ContraseñaText.getText();

        if (Brenda.equals(admin.getUsser()) && Brenda2024.equals(admin.getPassword())){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("menu-gerente-view.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                callEntrar.setTitle("Menu: \"Gerente\"");
                callEntrar.setScene(scene);
                callEntrar.show();
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }else {
            System.out.println("Verifica tus datos porfavor");
        }
    }

    @FXML
    void OnMouseClickedExitButton(MouseEvent event) {
        Stage stage = (Stage) ExitButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert UsuarioText != null : "fx:id=\"UsuarioText\" was not injected: check your FXML file 'gerente-view.fxml'.";
        assert ContraseñaText != null : "fx:id=\"ContraseñaText\" was not injected: check your FXML file 'gerente-view.fxml'.";
        assert EntrarButton != null : "fx:id=\"EntrarButton\" was not injected: check your FXML file 'gerente-view.fxml'.";
        assert ExitButton != null : "fx:id=\"ExitButton\" was not injected: check your FXML file 'gerente-view.fxml'.";

    }
}
