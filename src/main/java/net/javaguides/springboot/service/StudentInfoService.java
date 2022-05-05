package net.javaguides.springboot.service;

import net.javaguides.springboot.dto.CreateStudentDTO;
import net.javaguides.springboot.dto.LessonsForStudentResponseDTO;
import net.javaguides.springboot.dto.StudentsResponseDTO;
import net.javaguides.springboot.model.Lesson;
import net.javaguides.springboot.model.Parent;
import net.javaguides.springboot.model.Student;
import net.javaguides.springboot.model.Subscription;
import net.javaguides.springboot.repository.LessonRepository;
import net.javaguides.springboot.repository.ParentRepository;
import net.javaguides.springboot.repository.StudentRepository;
import net.javaguides.springboot.repository.SubscriptionRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentInfoService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LessonRepository lessonRepository;

    @Autowired
    private ParentRepository parentRepository;

    @Autowired
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<StudentsResponseDTO> getAllStudents() {

        return studentRepository.findAll().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    public List<LessonsForStudentResponseDTO> getLessonsForStudent(Long id) {
        return studentRepository.getById(id).getLessons().stream().map(this::convertEntityToDto).collect(Collectors.toList());
    }

    private StudentsResponseDTO convertEntityToDto(Student student){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(student, StudentsResponseDTO.class);
    }

    private LessonsForStudentResponseDTO convertEntityToDto(Lesson lesson){
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        return modelMapper.map(lesson, LessonsForStudentResponseDTO.class);
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
        if (student.getParent() != null)
            parentRepository.save(student.getParent());
        if (student.getSubscription() != null)
            subscriptionRepository.save(student.getSubscription());
        if (student.getLessons() != null)
            lessonRepository.saveAll(student.getLessons());
    }

    public String deleteStudent(Long id) {

        if (studentRepository.findById(id).isPresent()) {
            studentRepository.delete(studentRepository.getById(id));
            return "Student deleted";
        }
        else
            return "No such student found";
    }
}
