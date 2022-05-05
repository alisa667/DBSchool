package net.javaguides.springboot.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class SubscriptionDTO {

    private Integer thisMonthAttendance;
    private Integer thisMonthPaid;
}
