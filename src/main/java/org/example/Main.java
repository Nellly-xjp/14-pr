package org.example;

import com.github.javafaker.Faker;
import jakarta.persistence.*;
import org.example.entity.*;
import org.example.repository.*;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        Faker faker = new Faker();

        StudentRepository studentRepo = new StudentRepository(em);
        CourseRepository courseRepo = new CourseRepository(em);
        DepartmentRepository departmentRepo = new DepartmentRepository(em);

        em.getTransaction().begin();

        Department dep = new Department("IT");
        departmentRepo.save(dep);

        Course c1 = new Course("Java");
        Course c2 = new Course("SQL");

        courseRepo.save(c1);
        courseRepo.save(c2);

        for (int i = 0; i < 5; i++) {
            Student s = new Student(faker.name().fullName(), dep);
            s.setCourses(List.of(c1, c2));
            studentRepo.save(s);
        }

        em.getTransaction().commit();

        System.out.println("=== STUDENTS ===");
        studentRepo.findAll()
              .forEach(s -> System.out.println(s.getName()));

        em.getTransaction().begin();
        studentRepo.updateName(1L, "Updated Name");
        em.getTransaction().commit();

        em.getTransaction().begin();
        Student del = studentRepo.findById(2L);
        if (del != null) {
            studentRepo.delete(del);
        }
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}