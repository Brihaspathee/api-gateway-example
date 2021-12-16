package com.university.service.impl;

import com.university.domain.entity.Department;
import com.university.domain.repository.DepartmentRepository;
import com.university.service.interfaces.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 6:30 AM
 * Project: api-gateway-example
 * Package Name: com.university.service.impl
 * To change this template use File | Settings | File and Code Template
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department getDepartmentById(UUID departmentId) {
        return departmentRepository.findById(departmentId).orElseThrow(() -> {
            throw new RuntimeException("Department Not found");
        });
    }

    @Override
    public Set<Department> getAllDepartments() {
        return departmentRepository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }


}
