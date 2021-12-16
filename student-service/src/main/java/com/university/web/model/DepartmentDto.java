package com.university.web.model;

import lombok.*;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 4:19 PM
 * Project: api-gateway-example
 * Package Name: com.university.web.model
 * To change this template use File | Settings | File and Code Template
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DepartmentDto {

    private UUID departmentId;

    private String departmentName;
}
