package org.university.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.university.sp.entity.Subject;

import java.util.List;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {
    @Query("select DISTINCT s FROM Subject s JOIN s.course c WHERE c.id = :courseId")
    List<Subject> findAllSubjectsByCourseId(@Param("courseId") Long courseId);
    List<Subject> findAllByProfessorId(Long professorId);
}