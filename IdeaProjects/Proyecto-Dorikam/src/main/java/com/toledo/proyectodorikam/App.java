package com.toledo.proyectodorikam;

import com.toledo.proyectodorikam.controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Stage stageRoot = stage;
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Parent root = fxmlLoader.load();
        HomeController menuController = fxmlLoader.getController();
        menuController.init(stageRoot);

        Scene scene = new Scene(root);
        stage.setTitle("Dorikam - Home");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    private static Parent loadFXML(String fxml) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
