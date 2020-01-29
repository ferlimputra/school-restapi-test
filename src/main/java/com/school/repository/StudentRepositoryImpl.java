package com.school.repository;

import java.util.List;
import com.school.model.Classroom;
import com.school.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

/**
 * StudentRepositoryImpl
 */
public class StudentRepositoryImpl implements CustomStudentRepository {

    @Autowired
    ClassroomRepository classroomRepository;

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findByClassroomName(String className) {
        Classroom classroom = classroomRepository.findByRoomName(className)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No classname with room name " + className));
        return studentRepository.findByClassroom(classroom);
    }

}
