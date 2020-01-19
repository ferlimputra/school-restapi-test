package com.school.dto;

import java.util.UUID;

/**
 * ClassroomDTO
 */
public class ClassroomDTO {

    private UUID id;
    private String roomName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

}
