package net.javaguides.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Integer thisMonthAttendance;

    @Column
    private Integer thisMonthPaid;

    public Subscription(int thisMonthAttendance, int thisMonthPaid) {
        this.thisMonthAttendance = thisMonthAttendance;
        this.thisMonthPaid = thisMonthPaid;
    }
}
