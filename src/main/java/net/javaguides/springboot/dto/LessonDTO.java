package net.javaguides.springboot.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class LessonDTO {

    private String name;
    private String dateOfWeek;
    private Long startTime;
}
