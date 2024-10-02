package com.example.demo.dto;

import jakarta.validation.constraints.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

@Getter
@Setter
@EqualsAndHashCode
public class UserRequest {
    @NotBlank(message = "DTO VALIDATION: username should not be blank")
    private String name;
    @NotBlank(message = "DTO VALIDATION: email should not be blank")
    private String email;
    @NotBlank(message = "DTO VALIDATION: mobile should not be blank")
    private String mobile;
    private String gender;
    private Integer age;
    @NotBlank(message = "DTO VALIDATION: nationality should not be blank")
    private String nationality;

}
