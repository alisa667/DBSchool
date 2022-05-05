package net.javaguides.springboot.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LessonsForStudentResponseDTO {

    @JsonProperty
    //name of lesson
    private String name;

    @JsonProperty
    private String dateOfWeek;

    @JsonProperty
    private Long startTime;

}
