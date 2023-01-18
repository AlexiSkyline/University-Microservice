package org.university.sp.service;

import org.university.sp.entity.Course;

import java.util.List;

public interface ICourseService extends ICrudService<Course> {
    List<Course> findAllByProfessorId(Long professorId);
}