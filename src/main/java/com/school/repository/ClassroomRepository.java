package com.school.repository;

import java.util.Optional;
import java.util.UUID;
import com.school.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * ClassroomRepository
 */
@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, UUID> {

    public Optional<Classroom> findByRoomName(String roomName);
}
