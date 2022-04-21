package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;

@Entity
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer thisMonthAttendance;

    @Column
    private Integer getThisMonthPaid;
}
