package com.toledo.proyectodorikam;
import com.toledo.proyectodorikam.controllers.HomeController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("home-view.fxml"));
        Parent root = fxmlLoader.load();
        HomeController menuController = fxmlLoader.getController();
        menuController.init(stage);
        Scene scene = new Scene(root);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setTitle("Dorikam - Home");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
