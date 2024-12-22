package com.example.demo.student;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StudentMapperTest {

    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        studentMapper = new StudentMapper();

    }

    @Test
    public void shouldMapStudentDtoToStudent() {

        StudentDto studentDto = new StudentDto("osama", "faisal", "osama@mail.com", 1);
        Student student = studentMapper.toStudent(studentDto);
        assertEquals(studentDto.firstname(), student.getFirstname());
        assertEquals(studentDto.lastname(), student.getLastname());
        assertEquals(studentDto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(studentDto.schoolId(), student.getSchool().getId());

    }
}
