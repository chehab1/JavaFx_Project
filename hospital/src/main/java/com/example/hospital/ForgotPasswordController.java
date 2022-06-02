package com.example.hospital;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.hospital.ConnectionEstablish.con;

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
    private TextField forgetPassText;
    @FXML
    private void clickSendPassword(ActionEvent event)
    {
        String username = forgetPassText.getText();
        try {
            ConnectionEstablish.connect();
            Statement statement = con.createStatement();
            String q = "select * from login where email='" + username+ "'";
            ResultSet set = statement.executeQuery(q);
            if(set.next()==true)
            {
                AlertBox.display("Successful","An email with the password was sent to your email!");
            }
            else
            {
                AlertBox.display("Unsuccessful","This user is not registered!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
