package com.example.demo;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService{
    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public List<SchoolDto> getAll() {
        // return schoolRepository.findAll();
          return schoolRepository.findAll()
                .stream().map(schoolMapper::toSchoolDto).collect(Collectors.toList());
    }

    public SchoolDto getSchoolById(Integer id) {
        return schoolMapper.toSchoolDto(schoolRepository.getById(id));
    }

    public SchoolDto createSchool(SchoolDto schoolDto) {
        var school = schoolMapper.toSchool(schoolDto);
        schoolRepository.save(school);
        return schoolMapper.toSchoolDto(school);
    }

    public SchoolDto updateSchool(Integer id, SchoolDto schoolDto) {
        School school = schoolRepository.getById(id);
        school.setName(schoolDto.name());
 
        schoolRepository.save(school);
        return schoolMapper.toSchoolDto(school);
    }

    public void deleteSchool(Integer id) {
        schoolRepository.deleteById(id);
    }
}
