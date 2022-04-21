package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;

@Entity
public class College {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private String name;

}
