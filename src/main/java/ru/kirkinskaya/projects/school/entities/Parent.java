package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String fullName;

    @Column (unique = true)
    private Long phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @Column
    private List<Student> children = new ArrayList<>();

}
