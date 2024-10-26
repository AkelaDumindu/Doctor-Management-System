package com.akeladumindu.medex.controller;

import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class DoctorRegistrationFormController {

    public TextField txtFirstName;
    public TextField txtLastNane;
    public TextField txtNic;
    public TextField txtEmail;
    public TextField txtContact;
    public TextField txtSpecialization;
    public JFXRadioButton rBtnMale;
    public ToggleGroup genderType;
    public TextArea txtAddress;

    public void submitDataOnAction(ActionEvent actionEvent) {
    }


}
