package com.javamaster.spring_crud.prototype;

import com.javamaster.spring_crud.dto.UsersDto;
import com.javamaster.spring_crud.entity.Users;

public class UsersPrototype {

    public static Users aUser() {
        Users u = new Users();
        u.setName("test_name");
        u.setLogin("test_login");
        return u;
    }

    public static UsersDto aUserDTO() {
        return UsersDto.builder()
                .name("test_name")
                .login("test_login")
                .build();
    }
}
