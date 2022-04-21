package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;

@Entity
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    //todo: change type
    @Column
    private String dateOfWeek;

    //todo: change type
    @Column
    private Long startTime;

}
