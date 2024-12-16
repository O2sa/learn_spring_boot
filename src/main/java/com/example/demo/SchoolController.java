package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/schools")
public class SchoolController {
    private final SchoolService schoolService;

    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }

    // Get all schools
    @GetMapping
    public List<SchoolDto> getAllSchools() {
        return schoolService.getAll();
    }

    // Get school by ID
    @GetMapping("/{id}")
    public SchoolDto getSchoolById(@PathVariable Integer id) {
        return schoolService.getSchoolById(id);
    }

    // Create a new school
    @PostMapping
    public SchoolDto createSchool(@RequestBody SchoolDto schoolDto) {
        return schoolService.createSchool(schoolDto);
    }

    // Update a school
    @PutMapping("/{id}")
    public SchoolDto updateSchool(@PathVariable Integer id,
            @RequestBody SchoolDto schoolDetails) {
        return schoolService.updateSchool(id, schoolDetails);
    }

    // // Delete a school
    @DeleteMapping("/{id}")
    public void deleteSchool(@PathVariable Integer id) {
        schoolService.deleteSchool(id);
    }
}
