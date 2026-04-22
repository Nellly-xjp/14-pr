package org.example.repository;

import jakarta.persistence.EntityManager;
import org.example.entity.Course;

public class CourseRepository extends GenericRepositoryImpl<Course, Long> {

    public CourseRepository(EntityManager em) {
        super(em, Course.class);
    }
}