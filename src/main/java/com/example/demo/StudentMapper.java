package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class StudentMapper {


    public Student toStudent(StudentDto studentDetails) {
        Student student = new Student();
        var school = new School();
        school.setId(studentDetails.schoolId());
        student.setFirstname(studentDetails.firstname());
        student.setLastname(studentDetails.lastname());
        student.setEmail(studentDetails.email());
        student.setSchool(school);

        return student;
    }

    public StudentResponseDto toStudentResponseDto(Student student){
    return new StudentResponseDto(student.getFirstname(), student.getLastname(), student.getEmail());
}

}
