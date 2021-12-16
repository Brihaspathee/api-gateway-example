package com.university.web.controller;

import com.university.domain.entity.Student;
import com.university.service.interfaces.StudentService;
import com.university.web.model.StudentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 7:54 AM
 * Project: api-gateway-example
 * Package Name: com.university.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentResource {

    private final StudentService studentService;

    @GetMapping("/{studentId}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable("studentId")UUID studentId){
        StudentDto student = studentService.getStudentById(studentId);
        return ResponseEntity.ok().body(student);
    }

    @GetMapping
    public ResponseEntity getAllStudents(){
        Set<StudentDto> students = studentService.getAllStudents();
        return ResponseEntity.ok().body(students);
    }

    @PostMapping
    public ResponseEntity createStudent(@RequestBody StudentDto student) {
        StudentDto savedStudent = studentService.createStudent(student);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/student/" + savedStudent.getStudentId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
