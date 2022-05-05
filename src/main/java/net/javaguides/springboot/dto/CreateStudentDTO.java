package net.javaguides.springboot.dto;

import lombok.Data;
import java.sql.Date;
import java.util.List;

@Data
public class CreateStudentDTO {

    private String fullName;
    private Date dateOfBirth;
    private Date dateOfAdmission;
    private SubscriptionDTO subscription;
    private List<LessonDTO> lessons;
    private ParentDTO parent;


}
