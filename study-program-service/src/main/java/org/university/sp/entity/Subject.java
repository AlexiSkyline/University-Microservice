package org.university.sp.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static com.fasterxml.jackson.annotation.JsonProperty.Access.WRITE_ONLY;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "subjects")
@Getter @Setter
public class Subject {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer credits;
    @JsonProperty(access = WRITE_ONLY)
    @ManyToMany(mappedBy = "subjects")
    private List<Course> course;
    private Long professorId;
}