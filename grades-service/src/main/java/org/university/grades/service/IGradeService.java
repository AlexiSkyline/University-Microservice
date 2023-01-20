package org.university.grades.service;

import org.university.grades.entity.Grade;

import java.util.List;
import java.util.Optional;

public interface IGradeService {
    Grade save(Grade grade);
    List<Grade> findAll();
    Optional<Grade> findById(Long id);
    List<Grade> findAllByStudentId(Long StudentId);
    Grade update(Grade grade);
    Grade delete(Long id);
}