package com.school.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import com.school.model.Classroom;
import com.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * StudentRepository
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID>, CustomStudentRepository {

    public Optional<Student> findByName(String name);

    public List<Student> findByClassroom(Classroom classroom);
}
