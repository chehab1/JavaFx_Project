package com.example.hospital;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.hospital.ConnectionEstablish.con;

public class DoctorController implements Initializable {
    @FXML
    private ComboBox patientsCombo;
    private ObservableList data = FXCollections.observableArrayList();
    private Stage stage;
    private String username;
    private String specialty;

    private String valueCombo;
    private boolean bool;


    public void sendData(String username , String specialty) {
        this.username=username;
        this.specialty=specialty;

        try {

            ConnectionEstablish.connect();
            Statement statement = con.createStatement();
            data=FXCollections.observableArrayList();
            String q = "Select * from doctorform where DoctorSpeciality ='"+ specialty +"'";
            ResultSet set = statement.executeQuery(q);
            while(set.next()) {
                String name = set.getString("FirstName")+" "+set.getString("LastName");
                data.add(name);
            }
            patientsCombo.setItems(data);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
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
    public void clickSurgery(ActionEvent event) throws IOException {
        Stage st = new Stage();
        st.initModality(Modality.APPLICATION_MODAL);

//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Surgery.fxml"));
        Parent surgeryScreen = fxmlLoader.load();
        SurgeryController controller = fxmlLoader.getController();
        Scene scene = new Scene(surgeryScreen);
        st.setScene(scene);
        st.showAndWait();
    }

    @FXML
    public void clickShowData(ActionEvent event) throws IOException, SQLException {
        if(patientsCombo.getValue()==null)
        {
            AlertBox.display("Error","Please Select Patient!");
            return;
        }
        String[] arrayName;
        valueCombo= (String)patientsCombo.getValue();
        arrayName=valueCombo.split(" ");
        ConnectionEstablish.connect();
        Statement statement = con.createStatement();
        String q = "select * from doctorform where FirstName='" + arrayName[0] + "'" + " and LastName = '" + arrayName[1] + "'";
        ResultSet set = statement.executeQuery(q);
        Patients p;
        if(set.next())
        {
            int age = set.getInt("Age");
            int firstTime = set.getInt("FirstTime?");
            String gender = set.getString("Gender");
            String symptoms = set.getString("Symptoms");
            p= new Patients(valueCombo,age,firstTime,symptoms,gender);
        }
        else{
            AlertBox.display("Error","Please select patient!");
            return;
        }

        Stage st= new Stage();
//        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("ViewData.fxml"));
        Parent doctorScreen = fxmlLoader.load();
        ViewDataController controller = fxmlLoader.getController();
        controller.sendData(p);
        Scene scene = new Scene(doctorScreen);
        st.setScene(scene);
        st.show();


    }
    @FXML
    public void calculateRemainingDays(ActionEvent event) throws SQLException {
        ConnectionEstablish.connect();
        Statement statement = con.createStatement();
        String q = "select * from login where email='" + username + "'";
        ResultSet set = statement.executeQuery(q);
        if(set.next())
        {
            AlertBox.display(" Vacation Days ","Remaining Vacation Days Are : "+set.getInt("VcationDays"));
        }
        con.close();
    }
    @FXML
    public void calculateOvertime(ActionEvent event) throws SQLException {
        doctor dr = new doctor();
        //create object of doctor
        ConnectionEstablish.connect();
        Statement statement = con.createStatement();
        String q = "select * from login where email='" + username + "'";
        ResultSet set = statement.executeQuery(q);
        if(set.next())
        {
            int money = dr.staffCalculateOvertime(set.getInt("overtimeDays"));
            AlertBox.display(" Overtime","Total overtime salary : "+money);
        }
        con.close();
    }


}
