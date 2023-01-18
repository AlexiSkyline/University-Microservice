package org.university.professor.service;

import org.university.professor.entity.Professor;

import java.util.List;
import java.util.Optional;

public interface IProfessorService {
    Professor save(Professor professor);
    List<Professor> findAll();
    Optional<Professor> findById(Long id);
    Professor update(Professor professor);
    Professor delete(Long id);
}