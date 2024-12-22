package com.example.demo.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(
        @NotEmpty(message = "this filed must not be empty")
        String firstname,
        @NotEmpty(message = "this filed must not be empty")
        String lastname,
        String email,
        Integer schoolId) {

}
