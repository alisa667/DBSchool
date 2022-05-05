package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Data
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

    @ManyToOne(cascade = CascadeType.ALL)
    private Parent parent;


    public Student(String fullName, Date dateOfBirth, Date dateOfAdmission, List<Lesson> list, Parent parent, Subscription subscription) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmission = dateOfAdmission;
        this.lessons = list;
        this.parent = parent;
        this.subscription = subscription;
    }

    public Student(String fullName, Date dateOfBirth, Date dateOfAdmission) {
        this.fullName = fullName;
        this.dateOfBirth = dateOfBirth;
        this.dateOfAdmission = dateOfAdmission;
    }

    public void addLesson(){

    }
}
