package com.myfitnessbuddy.app.entity;

import java.util.List;

public class Exercise {
    private String exerciseName;
    private List<String> muscleGroupsWorked;
    private int sets;
    private int reps;
    private int weight;
    private int length;
    private String date;

    public Exercise(String exerciseName, List<String> muscleGroupsWorked, int sets, int reps, int weight, int length, String date) {
        this.exerciseName = exerciseName;
        this.muscleGroupsWorked = muscleGroupsWorked;
        this.sets = sets;
        this.reps = reps;
        this.weight = weight;
        this.length = length;
        this.date = date;
    }

    // GETTERS
    public String getExerciseName() { return exerciseName; }
    public List<String> getMuscleGroupsWorked() { return muscleGroupsWorked; }
    public int getSets() { return sets; }
    public int getReps() { return reps; }
    public int getWeight() { return weight; }
    public int getLength() { return length; }
    public String getDate() { return date; }

    // SETTERS
    public void setExerciseName(String exerciseName) { this.exerciseName = exerciseName; }
    public void setMuscleGroupsWorked(List<String> muscleGroupsWorked) { this.muscleGroupsWorked = muscleGroupsWorked; }
    public void setSets(int sets) { this.sets = sets; }
    public void setReps(int reps) { this.reps = reps; }
    public void setWeight(int weight) { this.weight = weight; }
    public void setLength(int length) { this.length = length; }
    public void setDate(String date) { this.date = date; }
}

