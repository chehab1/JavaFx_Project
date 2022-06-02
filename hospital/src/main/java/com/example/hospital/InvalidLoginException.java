package com.example.hospital;

import javafx.scene.control.Label;

import java.sql.SQLException;

import static com.example.hospital.ConnectionEstablish.con;

public class InvalidLoginException extends Exception{
    public InvalidLoginException(Label label) throws SQLException {
        label.setText("*Login Failed!");
        con.close();

    }
}
