package org.university.professor.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.university.professor.dto.CourseDTO;
import org.university.professor.dto.MajorDTO;
import org.university.professor.dto.SubjectDTO;

import java.util.List;

@FeignClient(name = "study-program-service")
public interface StudyProgramService {
    @GetMapping("majors/{id}")
    MajorDTO getMajorById(@PathVariable("id") Long id);

    @GetMapping("subjects/professor/{id}")
    List<SubjectDTO> getSubjectsByProfessorId(@PathVariable("id") Long id);

    @GetMapping("courses/professor/{id}")
    List<CourseDTO> getAllCoursesByProfessorId(@PathVariable("id") Long id);
}