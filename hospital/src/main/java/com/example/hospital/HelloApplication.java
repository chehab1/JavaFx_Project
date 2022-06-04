package com.example.hospital;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        HelloController controller = fxmlLoader.getController();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Fawzy's Hospital");
        stage.setScene(scene);
        stage.getIcons().add(new Image("C:\\Users\\CHEHAB YAKOOT\\Desktop\\JavaCodes\\Project_OOP\\logo.jpeg"));
        stage.show();
    }



    public static void main(String[] args) {
        launch();
    }
}