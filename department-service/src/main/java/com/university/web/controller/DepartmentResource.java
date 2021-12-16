package com.university.web.controller;

import com.university.domain.entity.Department;
import com.university.service.interfaces.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 6:34 AM
 * Project: api-gateway-example
 * Package Name: com.university.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/department")
public class DepartmentResource {

    private final DepartmentService departmentService;

    @GetMapping("/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable("departmentId") UUID departmentId){
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok().body(department);
    }

    @GetMapping
    public ResponseEntity getAllDepartments(){
        Set<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok().body(departments);
    }

    @PostMapping
    public ResponseEntity createDepartment(@RequestBody Department department){
        Department savedDepartment = departmentService.saveDepartment(department);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Location", "/api/v1/department/" + savedDepartment.getDepartmentId());
        return new ResponseEntity(headers, HttpStatus.CREATED);
    }
}
