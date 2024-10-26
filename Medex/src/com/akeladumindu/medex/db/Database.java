package com.akeladumindu.medex.db;

import com.akeladumindu.medex.dto.UserDto;
import com.akeladumindu.medex.enums.AccountType;

import java.util.ArrayList;

public class Database {

    public static ArrayList<UserDto> userTable = new ArrayList();

    static {
        userTable.add(new UserDto("Dumindu","Akela","akela@gmail.com","1234", AccountType.PATIENT));
        userTable.add(new UserDto("Thila","Dumi","dumi@gmail.com","1234", AccountType.DOCTOR));
    }
}
