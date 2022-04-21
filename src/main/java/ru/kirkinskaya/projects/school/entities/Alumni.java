package ru.kirkinskaya.projects.school.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Alumni {

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

    @Column
    private Date dateOfGraduation;

    @Column
    private boolean ifCommerce;

}
