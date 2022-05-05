package net.javaguides.springboot.controller;

import net.javaguides.springboot.dto.*;
import net.javaguides.springboot.model.Lesson;
import net.javaguides.springboot.model.Parent;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.Subscription;
import net.javaguides.springboot.service.StudentInfoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class StudentInfoController {

    @Autowired
    private StudentInfoService studentInfoService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("/students")
    public List<StudentsResponseDTO> getAllStudents(){
        return studentInfoService.getAllStudents();
    }

    @PutMapping("/new_student")
    public void addStudent(@RequestBody CreateStudentDTO createStudentDTO){

        Student student = modelMapper.map(createStudentDTO, Student.class);
        Parent parent;
        if (createStudentDTO.getParent() != null) {
            parent = modelMapper.map(createStudentDTO.getParent(), Parent.class);
            student.setParent(parent);
        }
        Subscription subscription;
        if (createStudentDTO.getSubscription() != null) {
            subscription = modelMapper.map(createStudentDTO.getSubscription(), Subscription.class);
            student.setSubscription(subscription);
        }

        List<Lesson> lessons;
        if (createStudentDTO.getLessons() != null) {
            lessons = lessonDtoToLessonList(createStudentDTO.getLessons());
            student.setLessons(lessons);
        }
        studentInfoService.saveStudent(student);
    }

    @DeleteMapping("/delete_student/{id}")
    public String deleteStudent(@PathVariable Long id){
        return studentInfoService.deleteStudent(id);
    }

    @PostMapping ("/update_parent/{id}")
    public void updateParent(@PathVariable Long id, @RequestBody ParentDTO parentDTO){

        if (parentDTO != null) {
            Parent parent = modelMapper.map(parentDTO, Parent.class);
        }
    }

    @GetMapping("/student_lessons/{id}")
    public List<LessonsForStudentResponseDTO> getLessonsForStudent(@PathVariable Long id){
        return studentInfoService.getLessonsForStudent(id);
    }

    private List<Lesson> lessonDtoToLessonList(List<LessonDTO> lessonDTOList){
        return lessonDTOList.stream().map(this::convertDtoToEntity).collect(Collectors.toList());

    }

    private Lesson convertDtoToEntity(LessonDTO lessonDTO) {
        return modelMapper.map(lessonDTO, Lesson.class);
    }

}
