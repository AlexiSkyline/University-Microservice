package org.university.student.feignclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.university.student.dto.CourseDTO;
import org.university.student.dto.MajorDTO;
import org.university.student.dto.SubjectDTO;

import java.util.List;

@FeignClient(name = "study-program-service")
public interface StudyProgramService {
    @GetMapping("majors/{id}")
    MajorDTO getMajorById(@PathVariable("id") Long id);

    @GetMapping("courses/{id}")
    CourseDTO getCourseById(@PathVariable("id") Long id);

    @GetMapping("subjects/course/{id}")
    List<SubjectDTO> getAllSubjectByCourseId(@PathVariable("id") Long id);
}