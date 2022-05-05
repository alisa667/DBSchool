package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    @NonNull
    private String fullName;

    @Column (unique = true)
    private Long phoneNumber;

    @OneToMany(cascade = CascadeType.ALL)
    @Column
    @NonNull
    private List<Student> children = new ArrayList<>();

    public Parent(String fullName, Long phoneNumber) {
        this.fullName = fullName;
        this.phoneNumber = phoneNumber;
    }
}
