package org.university.student.service;

import org.university.student.entity.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    Student save(Student student);
    List<Student> findAll();
    Optional<Student> findById(Long id);
    Optional<Student> findByRegistration(String registration);
    List<Student> findByMajorId(Long id);
    List<Student> findByCourseId(Long id);
    Student update(Student student);
    Student delete(Long id);
}