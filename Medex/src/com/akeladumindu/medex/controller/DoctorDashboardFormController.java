package com.akeladumindu.medex.controller;

import com.akeladumindu.medex.util.Cookie;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DoctorDashboardFormController {


    public AnchorPane doctorDashboardContext;
    public Label ldlDate;
    public Label ldlTime;

    public void initialize() throws IOException {
//        checkUser();
        
        initializedData();
    }

    private void initializedData() {

        ldlDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
        ldlTime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));
    }

    public void checkUser() throws IOException {

        if (null == Cookie.selectedUser){
            Stage stage = (Stage) doctorDashboardContext.getScene().getWindow();
            stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
        }
    }

}
