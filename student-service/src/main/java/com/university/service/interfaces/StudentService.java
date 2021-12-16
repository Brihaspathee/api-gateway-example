package com.university.service.interfaces;

import com.university.domain.entity.Student;
import com.university.web.model.StudentDto;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 7:50 AM
 * Project: api-gateway-example
 * Package Name: com.university.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface StudentService {

    StudentDto getStudentById(UUID studentId);

    Set<StudentDto> getAllStudents();

    StudentDto createStudent(StudentDto student);
}
