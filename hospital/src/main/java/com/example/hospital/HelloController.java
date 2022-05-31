package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloController {

    private Stage stage;

    @FXML
    public void clickForgotPassword(ActionEvent event) throws IOException
    {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Forgot_Password.fxml"));
        Parent forgetPasswordScreen = fxmlLoader.load();

        ForgotPasswordController controller = fxmlLoader.getController();
        Scene scene = new Scene(forgetPasswordScreen);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    public void clickLogin(ActionEvent event) throws IOException {

            stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Moderator.fxml"));
            Parent moderatorScreen = fxmlLoader.load();
            ModeratorController controller = fxmlLoader.getController();
            Scene scene = new Scene(moderatorScreen);
            stage.setScene(scene);
            stage.show();

    }
}