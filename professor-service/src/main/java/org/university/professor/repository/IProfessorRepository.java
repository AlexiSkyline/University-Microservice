package org.university.professor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.university.professor.entity.Professor;

import java.util.List;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {
    List<Professor> findAllByMajorId(Long majorId);
}