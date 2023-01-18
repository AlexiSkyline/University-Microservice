package org.university.professor.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "professors")
@Getter @Setter
public class Professor {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private String name;
    private String lastName;
    private String dateBirth;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String gender;
    private Long majorId;
}