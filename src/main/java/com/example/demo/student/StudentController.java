package com.example.demo.student;

import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

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
    public StudentResponseDto createStudent(@Valid @RequestBody StudentDto studentDto) {
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exp) {
        var errors = new HashMap<String, String>();
        exp.getBindingResult().getAllErrors().forEach(error -> {
            var fieldName = ((FieldError) error).getField();
            var errorMsg = error.getDefaultMessage();
            errors.put(fieldName, errorMsg);
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
