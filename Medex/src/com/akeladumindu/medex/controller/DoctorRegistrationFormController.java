package com.akeladumindu.medex.controller;

import com.akeladumindu.medex.db.Database;
import com.akeladumindu.medex.dto.DoctorDto;
import com.akeladumindu.medex.dto.UserDto;
import com.akeladumindu.medex.enums.GenderType;
import com.akeladumindu.medex.util.Cookie;
import com.jfoenix.controls.JFXRadioButton;
import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    public AnchorPane doctorRegistrationContext;

    public void initialize() {
        loadUserData();
    }

    private void loadUserData() {
        UserDto selectedUser = Cookie.selectedUser;
        txtFirstName.setText(selectedUser.getFirstName());
        txtLastNane.setText(selectedUser.getLastName());
        txtEmail.setText(selectedUser.getEmail());
    }

    public void submitDataOnAction(ActionEvent actionEvent) {

        DoctorDto doctorDto = new DoctorDto(
                txtFirstName.getText().trim(),
                txtLastNane.getText().trim(),
                txtNic.getText(),
                txtContact.getText(),
                txtEmail.getText().trim(),
                txtAddress.getText(),
                txtSpecialization.getText(),
                rBtnMale.isSelected()? GenderType.MALE: GenderType.FEMALE
        );

        Database.doctorTable.add(doctorDto);
        Stage stage = (Stage) doctorRegistrationContext.getScene().getWindow();
        stage.close();
    }


}
