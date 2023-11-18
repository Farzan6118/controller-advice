package com.example.demo.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UserRequest {
    private String name;
    private String email;
    private String mobile;
    private String gender;
    private Integer age;
    private String nationality;

}
