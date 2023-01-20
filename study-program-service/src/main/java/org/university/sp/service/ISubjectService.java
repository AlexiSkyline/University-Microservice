package org.university.sp.service;

import org.university.sp.entity.Subject;

import java.util.List;

public interface ISubjectService extends ICrudService<Subject> {
    List<Subject> findAllSubjectsByCourseId(Long courseId);
    List<Subject> findAllByProfessorId(Long professorId);
}