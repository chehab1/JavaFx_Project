package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.hospital.ConnectionEstablish.con;

public class AddMemberController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        doctorRadio.setSelected(true);
    }

    @FXML
    public void specialtyDisable() throws IOException
    {
        specialtyText.setDisable(true);
    }
    @FXML
    public void specialtyEnable() throws IOException
    {
        specialtyText.setDisable(false);
    }
    @FXML
    private RadioButton doctorRadio;
    @FXML
    private RadioButton nurseRadio;
    @FXML
    private RadioButton techRadio;
    @FXML
    private TextField nameText;
    @FXML
    private TextField specialtyText;
    @FXML
    private PasswordField passText;
    @FXML
    public void clickAdd(ActionEvent event) throws IOException, SQLException {
        String name = nameText.getText();
        String specialty = specialtyText.getText();
        String password = passText.getText();
        try{
            if(name=="" || password=="")
            {
            throw new NullPointerException();
            }
            else if(doctorRadio.isSelected())
            {
                ConnectionEstablish.connect();
                Statement statement = con.createStatement();
                String q = "Insert into  login (name,email,password,speciality,overtimeDays,VcationDays) VALUES( '"+name+"','" +"Dr"+name+ "@hospital.com','"+password+"','" + specialty + "','"+0+"','" + 30 + "')";
                statement.executeUpdate(q);
                AlertBox.display("Successful!","Doctor added Successfully!");
            }
            else  if(nurseRadio.isSelected())
            {
                ConnectionEstablish.connect();
                Statement statement = con.createStatement();
                String q = "Insert into  login (name,email,password,overtimeDays,VcationDays) VALUES( '"+name+"','" +"Nurse"+name+ "@hospital.com','"+password+"','"+0+"','" + 30 + "')";
                statement.executeUpdate(q);
                AlertBox.display("Successful!","Nurse added Successfully!");
            }
            else if(techRadio.isSelected())
            {
                ConnectionEstablish.connect();
                Statement statement = con.createStatement();
                String q = "Insert into  login (name,email,password,overtimeDays,VcationDays) VALUES( '"+name+"','" +"Tech"+name+ "@hospital.com','"+password+"','"+0+"','" + 30 + "')";
                statement.executeUpdate(q);
                AlertBox.display("Successful!","Tech added Successfully!");
            }
        }catch(NullPointerException e)
        {
            AlertBox.display("Error!","Please fill in all fields.");
        }
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
