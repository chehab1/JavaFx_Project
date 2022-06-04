package com.example.hospital;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.hospital.ConnectionEstablish.con;

public class NurseController implements Initializable {
    private Stage stage;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void clickLogout(ActionEvent event) throws IOException {
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent helloScreen = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();
        Scene scene = new Scene(helloScreen);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private Label nurseName;
    @FXML
    private Label room;

    private String name;
    public void sendData(String name) throws SQLException {
        this.name = name;
        ConnectionEstablish.connect();
        Statement statement = con.createStatement();
        String q = "select * from nurseform where name='" + name + "'";
        ResultSet set = statement.executeQuery(q);
        if(set.next()){
        nurseName.setText(name);
        room.setText(Integer.toString(set.getInt("room")));
        }
        con.close();
    }

    @FXML
    public void calculateRemainingDays(ActionEvent event) throws SQLException {
        ConnectionEstablish.connect();
        Statement statement = con.createStatement();
        String q = "select * from login where name='" + name + "'";
        ResultSet set = statement.executeQuery(q);
        if(set.next())
        {
            AlertBox.display(" Vacation Days ","Remaining Vacation Days Are : "+set.getInt("VcationDays"));
        }
        con.close();
    }
    @FXML
    public void calculateOvertime(ActionEvent event) throws SQLException {
        nurse nr = new nurse();
        //create object of nurse

        ConnectionEstablish.connect();
        Statement statement = con.createStatement();
        String q = "select * from login where name='" + name + "'";
        ResultSet set = statement.executeQuery(q);
        if(set.next())
        {
            int money = nr.staffCalculateOvertime(set.getInt("overtimeDays"));
            AlertBox.display(" Overtime","Total overtime salary : "+money);
        }
        con.close();
    }
}