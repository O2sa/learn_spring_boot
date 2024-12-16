package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolRepository schoolRepository;

    public SchoolController(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    // Get all schools
    @GetMapping
    public List<SchoolDto> getAllSchools() {
        return schoolRepository.findAll()
                .stream().map(this::toSchoolDto).collect(Collectors.toList());
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
    // Get school by ID
    // @GetMapping("/{id}")
    // public ResponseEntity<School> getSchoolById(@PathVariable Integer id) {
    // return ResponseEntity.ok(schoolRepository.findAllById(id));
    // }

    // Create a new school
    @PostMapping
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        schoolRepository.save(toSchool(schoolDto));
        return schoolDto;
    }

    private School toSchool(SchoolDto schoolDto) {
        School school = new School();
        school.setName(schoolDto.name());
        return school;
    }

    // Update a school
    // @PutMapping("/{id}")
    // public ResponseEntity<School> updateSchool(@PathVariable Integer id,
    // @RequestBody School schoolDetails) {
    // return ResponseEntity.ok(schoolRepository.updateSchool(id, schoolDetails));
    // }

    // // Delete a school
    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteSchool(@PathVariable Integer id) {
    // schoolRepository.deleteSchool(id);
    // return ResponseEntity.noContent().build();
    // }
}
