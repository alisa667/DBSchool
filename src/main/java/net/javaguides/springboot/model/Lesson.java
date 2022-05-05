package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
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

    public Lesson(String name, String dateOfWeek, Long startTime) {
        this.name = name;
        this.dateOfWeek = dateOfWeek;
        this.startTime = startTime;
    }
}
