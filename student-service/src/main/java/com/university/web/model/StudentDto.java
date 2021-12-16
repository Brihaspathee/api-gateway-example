package com.university.web.model;

import lombok.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 4:17 PM
 * Project: api-gateway-example
 * Package Name: com.university.web.controller
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentDto {

    private UUID studentId;

    private String firstName;

    private String lastName;

    private DepartmentDto departmentDto;
}
