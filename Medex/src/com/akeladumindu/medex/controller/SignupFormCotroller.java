package com.akeladumindu.medex.controller;

import com.akeladumindu.medex.db.Database;
import com.akeladumindu.medex.dto.UserDto;
import com.akeladumindu.medex.enums.AccountType;
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
import java.util.Optional;

public class SignupFormCotroller {

    public AnchorPane signUpContext;
    public JFXTextField txtFirstName;
    public JFXTextField txtLastName;
    public JFXTextField txtEmail;
    public JFXPasswordField txtPassword;
    public JFXRadioButton rBtnDoctor;
    public ToggleGroup accountType;

    public void signUpOnAction(ActionEvent actionEvent) throws IOException {

        String email = txtEmail.getText();
        Optional<UserDto> selectedUser =  Database.userTable.stream()
                .filter(e -> e.getEmail().equals(email.trim().toLowerCase()))
                .findFirst();

        if (selectedUser.isPresent()) {
            new Alert(Alert.AlertType.WARNING,"Email is already exist").show();
            return;
        }

        Database.userTable.add(
                new UserDto(txtLastName.getText(),txtFirstName.getText(),email,txtPassword.getText(),rBtnDoctor.isSelected()? AccountType.DOCTOR:AccountType.PATIENT)
        );
        new Alert(Alert.AlertType.CONFIRMATION,"Welcome!").show();

        //after successful register user should redirect to the login page
        setUi();
    }

    public void alreadyHaveAnAccountOnAction(ActionEvent actionEvent) throws IOException {
                setUi();

    }

    private void setUi() throws IOException {
        Stage stage = (Stage) signUpContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/LoginForm.fxml"))));
    }

    }

