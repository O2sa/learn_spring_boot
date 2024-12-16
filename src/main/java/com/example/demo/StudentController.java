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
    public ResponseEntity<Student> getStudentById(@PathVariable Integer id) {
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    // Create a new student
    @PostMapping
    public StudentResponseDto createStudent(@RequestBody StudentDto studentDto) {
        var student = toStudent(studentDto);
        Student savedStudent=studentService.createStudent(student);

        return toStudentResponseDto(savedStudent);
    }

    private Student toStudent(StudentDto studentDetails) {
        Student student = new Student();
        var school = new School();
        school.setId(studentDetails.schoolId());
        student.setFirstname(studentDetails.firstname());
        student.setLastname(studentDetails.lastname());
        student.setEmail(studentDetails.email());
        student.setSchool(school);

        return student;
    }

private StudentResponseDto toStudentResponseDto(Student student){
    return new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());
}

    // Update a student
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id, @RequestBody Student studentDetails) {
        return ResponseEntity.ok(studentService.updateStudent(id, studentDetails));
    }

    // Delete a student
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
}
