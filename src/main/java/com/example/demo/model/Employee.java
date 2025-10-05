package com.example.demo.model;

import com.example.demo.enums.Gender;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
public class Employee extends BaseEntity<Integer> {

    private String firstName;
    private String lastName;
    private String email;
    private String mobile;
    private String nationalCode;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private LocalDate birthDate;
    private String nationality;
    private LocalDate entryYear;
}