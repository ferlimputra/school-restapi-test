package com.school.repository;

import java.util.List;
import com.school.model.Student;

/**
 * CustomStudentRepository
 */
public interface CustomStudentRepository {

    public List<Student> findByClassroomName(String className);

}
