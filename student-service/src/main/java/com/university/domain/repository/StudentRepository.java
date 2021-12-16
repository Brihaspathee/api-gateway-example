package com.university.domain.repository;

import com.university.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

/**
 * Created in Intellij IDEA
 * User: Balaji Varadharajan
 * Date: 15, December 2021
 * Time: 7:49 AM
 * Project: api-gateway-example
 * Package Name: com.university.domain.repository
 * To change this template use File | Settings | File and Code Template
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {
}
