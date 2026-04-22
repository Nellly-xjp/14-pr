package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Department;

public class DepartmentRepository extends GenericRepositoryImpl<Department, Long> {

    public DepartmentRepository(EntityManager em) {
        super(em, Department.class);
    }
}