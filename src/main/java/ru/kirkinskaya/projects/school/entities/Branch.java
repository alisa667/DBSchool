package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    Long id;

    @Column
    String address;

}
