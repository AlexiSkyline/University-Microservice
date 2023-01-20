package org.university.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    private Long id;
    private String name;
    private String description;
    private Integer credits;
    private Long professorId;
    private Float finalGrade;
}