package com.akeladumindu.medex.db;

import com.akeladumindu.medex.dto.DoctorDto;
import com.akeladumindu.medex.dto.UserDto;
import com.akeladumindu.medex.enums.AccountType;
import com.akeladumindu.medex.enums.GenderType;

import java.util.ArrayList;

public class Database {

    public static ArrayList<UserDto> userTable = new ArrayList();
    public static ArrayList<DoctorDto> doctorTable = new ArrayList();

    static {

        //-------------------------
        userTable.add(new UserDto("Dumindu","Akela","akela@gmail.com","1234", AccountType.PATIENT));
        userTable.add(new UserDto("Thila","Dumi","dumi@gmail.com","1234", AccountType.DOCTOR));
        //-----------------------------

        //-------------------------
        doctorTable.add(
                new DoctorDto(
                        "Dumi",
                        "Thila",
                        "123456789",
                        "+123458",
                        "dumi@gmail.com",
                        "Galle",
                        "Sample 1",
                        GenderType.MALE
                )
        );
    }
}
