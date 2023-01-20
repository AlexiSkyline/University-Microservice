package org.university.grades.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "grades")
@Getter @Setter
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Float finalGrade;
    private Long courseId;
    private Long subjectId;
    private Long majorId;
    private Long studentId;
}