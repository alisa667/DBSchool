package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;

@Entity
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String fullName;

    @Column (unique = true)
    private Long phoneNumber;


}
