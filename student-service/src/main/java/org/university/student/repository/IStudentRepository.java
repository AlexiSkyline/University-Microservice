package org.university.student.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.university.student.entity.Student;

import java.util.List;
import java.util.Optional;

@Repository
public interface IStudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByMajorId(Long id);
    Optional<Student> findStudentByRegistration(String registration);
    List<Student> findByCourseId(Long id);
}