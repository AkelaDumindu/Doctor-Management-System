package com.akeladumindu.medex.util;

import com.akeladumindu.medex.db.Database;
import com.akeladumindu.medex.dto.UserDto;

public class Cookie {

    public static UserDto selectedUser = Database.userTable.get(1);
}
