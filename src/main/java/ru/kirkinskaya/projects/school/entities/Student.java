package ru.kirkinskaya.projects.school.entities;

import lombok.*;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String fullName;

    @Column
    private Date dateOfBirth;

    @Column
    private Date dateOfAdmission;

    @OneToOne(cascade = CascadeType.ALL)
    private Subscription subscription;

    @OneToMany(cascade = CascadeType.ALL)
    @Column
    private List<Lesson> lessons = new ArrayList<>();

}
