package org.university.student.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GradeDTO {
    private Long id;
    private Float finalGrade;
    private Long subjectId;
}