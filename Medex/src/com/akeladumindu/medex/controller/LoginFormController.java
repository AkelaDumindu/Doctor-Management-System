package com.akeladumindu.medex.controller;

import com.akeladumindu.medex.db.Database;
import com.akeladumindu.medex.dto.UserDto;
import com.akeladumindu.medex.enums.AccountType;
import com.akeladumindu.medex.util.Cookie;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {

    public JFXTextField txtEmail;
    public JFXRadioButton rBtnDoctor;
    public ToggleGroup accountType;
    public JFXPasswordField txtPassword;
    public AnchorPane loginContext;


    public void signInOnAction(ActionEvent actionEvent) throws IOException {

        String email = txtEmail.getText();
        String password = txtPassword.getText();
        AccountType accountType = rBtnDoctor.isSelected() ? AccountType.DOCTOR : AccountType.PATIENT;

//        read all users
        for (UserDto dto : Database.userTable){
//            check email who has
            if(dto.getEmail().trim().toLowerCase().equals(email)){
                //check the password
                if (dto.getPassword().equals(password)){
//                    check account type is equal who has entered
                    if (dto.getAccountType().equals(accountType)){
                        new Alert(Alert.AlertType.CONFIRMATION,"Success!").show();

                        Cookie.selectedUser=dto;
                        setUi("DoctorDashboardForm");
                        return;
                    }else{
                        new Alert(Alert.AlertType.WARNING, String.format("We can't find your %s Account", accountType.name())).show();
                        return;
                    }
                }else {
                    new Alert(Alert.AlertType.WARNING,"Your Password is incorrect!").show();
                    return;
                }
            }}
                new Alert(Alert.AlertType.WARNING, String.format("We can't find an email (%s)", email)).show();






    }

    public void createAccountOnAction(ActionEvent actionEvent) throws IOException {
                setUi("SignupForm");

    }


    private void setUi(String location) throws IOException {
        Stage stage = (Stage) loginContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }
}
