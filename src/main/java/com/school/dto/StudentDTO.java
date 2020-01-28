package com.school.dto;

import java.util.UUID;

/**
 * StudentDTO
 */
public class StudentDTO {

    private UUID id;
    private String name;
    private int score;
    private UUID classroom;
    private String classroomName;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public UUID getClassroom() {
        return classroom;
    }

    public void setClassroom(UUID classroom) {
        this.classroom = classroom;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

}
