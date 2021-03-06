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

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SurgeryController implements Initializable {
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Doctor.fxml"));
        Parent doctorScreen = fxmlLoader.load();
        DoctorController controller = fxmlLoader.getController();
        Scene scene = new Scene(doctorScreen);
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    public void schedule(ActionEvent event)
    {
        stage= (Stage) ((Node)event.getSource()).getScene().getWindow();
        AlertBox.display("Done","Surgery booked");

    }
}
