package com.myfitnessbuddy.app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "exercises")
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @JsonBackReference
    private User user;

    private String exerciseName;
    private List<String> muscleGroupsWorked;
    private int sets;
    private int reps;
    private int weight;
    private int length; // what is length? Like a time duration of the exercise?
    private LocalDate date;

    public Exercise() {}

    public Exercise(User user, String exerciseName, List<String> muscleGroupsWorked, int sets, int reps, int weight, int length, LocalDate date) {
        this.user = user;
        this.exerciseName = exerciseName;
        this.muscleGroupsWorked = muscleGroupsWorked;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.length = length;
        this.date = date;
    }

    // GETTERS
    public Long getId() { return id; }
    public User getUser() { return user; }
    public String getExerciseName() { return exerciseName; }
    public List<String> getMuscleGroupsWorked() { return muscleGroupsWorked; }
    public int getSets() { return sets; }
    public int getReps() { return reps; }
    public int getWeight() { return weight; }
    public int getLength() { return length; }
    public LocalDate getDate() { return date; }

    // SETTERS
    public void setUser(User user) { this.user = user; }
    public void setExerciseName(String exerciseName) { this.exerciseName = exerciseName; }
    public void setMuscleGroupsWorked(List<String> muscleGroupsWorked) { this.muscleGroupsWorked = muscleGroupsWorked; }
    public void setSets(int sets) { this.sets = sets; }
    public void setReps(int reps) { this.reps = reps; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setLength(int length) { this.length = length; }
    public void setDate(LocalDate date) { this.date = date; }

    // consider add toString method for testing purposes
}

