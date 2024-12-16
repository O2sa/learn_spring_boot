package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

 

  

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student getStudentById(Integer id) {
        return studentRepository.getById(id);
    }

    public Student createStudent(Student user) {
        return studentRepository.save(user);
    }

    public Student updateStudent(Integer id, Student userDetails) {
        Student user = getStudentById(id);
        return studentRepository.save(userDetails);
    }

    public void deleteStudent(Integer id) {
        studentRepository.deleteById(id);
    }
}
