package com.umsss.users.application.model.repository;

import com.umsss.users.application.model.domain.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Santiago Mamani
 */
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
