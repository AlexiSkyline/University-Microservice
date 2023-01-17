package org.university.sp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.List;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "majors")
@Getter @Setter
public class Major {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Integer duration;
    private Integer totalPoints;
    @OneToMany(cascade = ALL)
    private List<Subject> subjects;
    @OneToMany(cascade = ALL)
    private List<Course> courses;
}