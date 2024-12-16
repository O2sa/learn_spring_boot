package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get all students
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    // Get student by ID
    @GetMapping("/{id}")
    public StudentResponseDto getStudentById(@PathVariable Integer id) {
        return studentService.getStudentById(id);
    }

    // Create a new student
    @PostMapping
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        return studentService.createStudent(studentDto);
    }

    // Update a student
    @PutMapping("/{id}")
    public StudentResponseDto updateStudent(@PathVariable Integer id, @RequestBody StudentDto studentDto) {
        return studentService.updateStudent(id, studentDto);
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }
}
