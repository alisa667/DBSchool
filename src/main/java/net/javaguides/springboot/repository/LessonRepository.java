package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Lesson;
import net.javaguides.springboot.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Long> {
}
