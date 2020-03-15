package com.javamaster.spring_crud.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;
}
