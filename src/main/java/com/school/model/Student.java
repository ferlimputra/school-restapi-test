package com.school.model;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Student
 */
@Entity
public class Student {

    @Id
    @GeneratedValue
    private UUID id;

    @NotBlank
    private String name;

    @NotNull
    private int score;

    @ManyToOne(cascade = CascadeType.ALL)
    private Classroom classroom;

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

    public void setScore(int Score) {
        this.score = Score;
    }

}
