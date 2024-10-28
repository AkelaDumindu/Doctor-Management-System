package com.akeladumindu.medex.controller;

import com.akeladumindu.medex.db.Database;
import com.akeladumindu.medex.dto.DoctorDto;
import com.akeladumindu.medex.util.Cookie;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Optional;

public class DoctorDashboardFormController {


    public AnchorPane doctorDashboardContext;
    public Label ldlDate;
    public Label ldlTime;

    public void initialize() throws IOException {
//        checkUser();
        
        initializedData();
        checkDoctorData();
    }

    private void initializedData() throws IOException {

        ldlDate.setText(new SimpleDateFormat("dd-MM-yyyy").format(new Date()));
//        ldlTime.setText(new SimpleDateFormat("HH:mm:ss").format(new Date()));

        Timeline timeline = new Timeline(
                new KeyFrame(Duration.seconds(0), e->{
                    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss");
                    ldlTime.setText(LocalTime.now().format(dtf));
                }),
                new KeyFrame(Duration.seconds(1))
        );

        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        checkDoctorData();

    }

    private void checkDoctorData() throws IOException {
        Optional<DoctorDto> selectedDoctor = Database.doctorTable.stream().filter(e -> e.getEmail().equals("dumi@gmail.com")).findFirst();
//        if(!selectedDoctor.isPresent()){
//            setUi("DoctorRegistrationForm");
//        }

        if(!selectedDoctor.isPresent()) {
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.
                    load(getClass().getResource("../view/DoctorRegistrationForm.fxml"))));
            stage.centerOnScreen();
            stage.show();
        }

    }

    public void checkUser() throws IOException {

        if (null == Cookie.selectedUser){
           setUi("LoginForm");
        }
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) doctorDashboardContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/"+location+".fxml"))));
    }

}
