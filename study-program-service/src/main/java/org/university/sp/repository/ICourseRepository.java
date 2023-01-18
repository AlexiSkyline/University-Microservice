package org.university.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.university.sp.entity.Course;

import java.util.List;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {
    @Query("select DISTINCT c from Course c JOIN c.subjects s WHERE s.professorId = :professorId")
    List<Course> findAllByProfessorId(@Param("professorId") Long professorId);
}