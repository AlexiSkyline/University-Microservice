package org.university.student.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
public class CourseDTO implements Serializable {
    private Long id;
    private String name;
    private Integer semester;
}