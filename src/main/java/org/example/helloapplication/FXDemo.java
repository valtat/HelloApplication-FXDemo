package org.example.helloapplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXDemo extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("fx-demo.fxml"));
        stage.setTitle("FXDemo");
        Scene scene = new Scene(fxmlLoader.load(), 620, 440);
        stage.setScene(scene);
        stage.show();
    }
}
