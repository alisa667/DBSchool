package net.javaguides.springboot.repository;

import net.javaguides.springboot.model.Parent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentRepository extends JpaRepository<Parent, Long> {
}
