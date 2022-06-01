package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AddMemberController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    private TextField nameText;
    @FXML
    private TextField specialtyText;
    @FXML
    private PasswordField passText;
    @FXML
    public void clickAdd(ActionEvent event) throws IOException {
        String name = nameText.getText();
        String specialty = specialtyText.getText();
        String password = passText.getText();
    }

    @FXML
    private Stage stage;
    public void BackButton(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Moderator.fxml"));
        Parent addMemberScreen = fxmlLoader.load();
        ModeratorController controller = fxmlLoader.getController();
        Scene scene = new Scene(addMemberScreen);
        stage.setScene(scene);
        stage.show();
    }

}
