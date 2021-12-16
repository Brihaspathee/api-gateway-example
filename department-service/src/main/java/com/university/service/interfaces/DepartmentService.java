package com.university.service.interfaces;

import com.university.domain.entity.Department;

import java.util.Set;
import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 6:28 AM
 * Project: api-gateway-example
 * Package Name: com.university.service.interfaces
 * To change this template use File | Settings | File and Code Template
 */
public interface DepartmentService {

    Department getDepartmentById(UUID departmentId);

    Set<Department> getAllDepartments();

    Department saveDepartment(Department department);
}
