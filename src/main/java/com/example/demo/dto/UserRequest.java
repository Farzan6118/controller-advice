package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class UserRequest {
    @NotNull(message = "username should not be null")
    private String name;
    @Email(message = "enter a valid email")
    private String email;
    @NotNull
    @Pattern(regexp = "^\\d{10}$", message = "invalid mobile number entered")
    private String mobile;
    private String gender;
    @Min(18)
    @Max(60)
    private Integer age;
    @Size(min = 10, max = 10, message = "the size should be exactly 10")
    private String nationality;

}
