package com.school.repository;

import java.util.Optional;
import java.util.UUID;
import com.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * StudentRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> {

    public Optional<Student> findByName(String name);
}
