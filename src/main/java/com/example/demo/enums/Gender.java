package com.example.demo.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Optional;

@Getter
@AllArgsConstructor
public enum Gender {

    UNSPECIFIED(0, "unspecified"),
    FEMALE(1, "female"),
    MALE(2, "male"),
    OTHER(99, "other");

    private final Integer id;
    private final String title;

    @JsonCreator
    public static Gender fromString(String value) {
        if (value == null) return UNSPECIFIED;
        return switch (value.toLowerCase()) {
            case "male" -> MALE;
            case "female" -> FEMALE;
            case "other" -> OTHER;
            case "unspecified" -> UNSPECIFIED;
            default -> throw new IllegalArgumentException("Invalid gender value: " + value);
        };
    }

    public static Optional<Gender> findById(int id) {
        for (Gender gender : Gender.values()) {
            if (gender.id == id) {
                return Optional.of(gender);
            }
        }
        return Optional.empty();
    }
}
