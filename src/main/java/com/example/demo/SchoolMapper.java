package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {


    public School toSchool(SchoolDto schoolDetails) {
        School school = new School();
        school.setName(schoolDetails.name());


        return school;
    }

    public SchoolDto toSchoolDto(School school){
    return new SchoolDto(school.getName());
}

}
