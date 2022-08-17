package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRequest {
    private int id;
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;

}
