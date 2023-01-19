package org.university.professor.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    private Long id;
    private String name;
    private String description;
    private Integer credits;
}