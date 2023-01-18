package org.university.professor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.university.professor.entity.Professor;

@Repository
public interface IProfessorRepository extends JpaRepository<Professor, Long> {
}