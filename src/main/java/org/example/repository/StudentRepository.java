package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Student;

public class StudentRepository extends GenericRepositoryImpl<Student, Long> {

    public StudentRepository(EntityManager em) {
        super(em, Student.class);
    }

    public void updateName(Long id, String newName) {
        Student s = findById(id);
        if (s != null) {
            s.setName(newName);
        }
    }
}