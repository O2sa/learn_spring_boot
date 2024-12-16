package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public StudentResponseDto getStudentById(Integer id) {
        return studentMapper.toStudentResponseDto(studentRepository.getById(id));
    }

    public StudentResponseDto createStudent(StudentDto studentDto) {
        var student = studentMapper.toStudent(studentDto);
        studentRepository.save(student);
        return studentMapper.toStudentResponseDto(student);
    }

    public StudentResponseDto updateStudent(Integer id, StudentDto studentDto) {
        Student student = studentRepository.getById(id);
        student.setFirstname(studentDto.firstname());
        student.setLastname(studentDto.lastname());
        student.setEmail(studentDto.email());
        studentRepository.save(student);
        return studentMapper.toStudentResponseDto(student);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
