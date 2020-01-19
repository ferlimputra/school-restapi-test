package com.school.service;

import java.util.Optional;
import com.school.model.Classroom;
import com.school.repository.ClassroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ClassroomService
 */
@Service
public class ClassroomService {

    @Autowired
    ClassroomRepository classroomRepository;

    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    public Optional<Classroom> findByRoomName(String roomName) {
        return classroomRepository.findByRoomName(roomName);
    }
}
