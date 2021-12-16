package com.university.service.impl;

import com.university.domain.entity.Student;
import com.university.domain.repository.StudentRepository;
import com.university.service.interfaces.StudentService;
import com.university.web.model.DepartmentDto;
import com.university.web.model.StudentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 7:51 AM
 * Project: api-gateway-example
 * Package Name: com.university.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final RestTemplate restTemplate;

    @Override
    public StudentDto getStudentById(UUID studentId) {
        Student student =  studentRepository.findById(studentId).orElseThrow(() -> {
            throw new RuntimeException("Student Not Found");
        });
        StudentDto studentDto = studentToStudentDto(student);
        studentDto.setDepartmentDto(getStudentDepartment(student.getDepartmentId()));
        return studentDto;
    }

    @Override
    public Set<StudentDto> getAllStudents() {
        return studentRepository.findAll().stream().map(student -> {
            StudentDto studentDto = studentToStudentDto(student);
            studentDto.setDepartmentDto(getStudentDepartment(student.getDepartmentId()));
            return studentDto;
        }).collect(Collectors.toSet());

    }

    @Override
    public StudentDto createStudent(StudentDto studentDto) {
        Student savedStudent = studentRepository.save(studentDtoToStudent(studentDto));
        return studentToStudentDto(savedStudent);
    }

    private DepartmentDto getStudentDepartment(String departmentId){
        UUID deptId = UUID.fromString(departmentId);
        ResponseEntity<DepartmentDto> department = restTemplate.getForEntity("http://DEPARTMENT-SERVICE/api/v1/department/"+deptId, DepartmentDto.class);
        return department.getBody();
    }

    private StudentDto studentToStudentDto(Student student){
        return StudentDto.builder()
                .studentId(student.getStudentId())
                .firstName(student.getFirstName())
                .lastName(student.getLastName())
                .build();
    }

    private Student studentDtoToStudent(StudentDto studentDto){
        return Student.builder()
                .studentId(studentDto.getStudentId())
                .firstName(studentDto.getFirstName())
                .lastName(studentDto.getLastName())
                .departmentId(studentDto.getDepartmentDto().getDepartmentId().toString())
                .build();
    }
}
