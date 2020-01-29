package com.school.service;

import java.util.List;
import com.school.model.Classroom;
import com.school.model.Student;
import com.school.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 * StudentService
 */
@Service
public class StudentService {

    @Autowired
    ClassroomService classroomService;

    @Autowired
    StudentRepository studentRepository;

    public Student findByName(String name) {
        return studentRepository.findByName(name)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("No student found with name %s", name)));
    }

    public Student save(Student student, String classroomName) {
        Classroom classroom = classroomService.findByRoomName(classroomName)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("No room found with name %s", classroomName)));
        student.setClassroom(classroom);
        return studentRepository.save(student);
    }

    public List<Student> findByClassroomName(String className) {
        return studentRepository.findByClassroomName(className);
    }
}
