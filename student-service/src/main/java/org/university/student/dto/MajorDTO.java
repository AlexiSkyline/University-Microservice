package org.university.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MajorDTO {
    private Long id;
    private String name;
    private String description;
    private Integer duration;
    private Integer totalPoints;
}