package com.umsss.users.application.model.repository;

import com.umsss.users.application.model.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Santiago Mamani
 */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
