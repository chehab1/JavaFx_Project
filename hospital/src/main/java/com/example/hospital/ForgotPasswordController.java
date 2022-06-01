package com.example.hospital;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ForgotPasswordController implements Initializable
{
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

    }

    private Stage stage;
    @FXML
    public void BackButton(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent helloScreen = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();
        Scene scene = new Scene(helloScreen);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void clickSendPassword(ActionEvent event)
    {
        AlertBox.display("Done","Email sent successfully");
    }
}
