package org.university.professor.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class CourseDTO {
    private Long id;
    private String name;
    private Integer semester;
    private List<SubjectDTO> subjects;
}