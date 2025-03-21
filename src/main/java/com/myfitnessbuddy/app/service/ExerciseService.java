package com.myfitnessbuddy.app.service;

import com.myfitnessbuddy.app.entity.Exercise;
import com.myfitnessbuddy.app.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ExerciseService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    // Basic CRUD ops below :)
    // CREATE
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }

    // READ
    public Exercise getExerciseById(Long id) {
        return exerciseRepository.findById(id).orElse(null);
    }

    public List<Exercise> getAllExercises() {
        return exerciseRepository.findAll();
    }

    public List<Exercise> getExercisesByUserId(Long userId) {
        return exerciseRepository.findByUserId(userId);
    }

    // UPDATE
    public Exercise updateExercise(Long id, Exercise exerciseDetails) {
        Optional<Exercise> optionalExercise = exerciseRepository.findById(id);

        if (optionalExercise.isPresent()) {
            Exercise exercise = optionalExercise.get();
    
            exercise.setExerciseName(exerciseDetails.getExerciseName());
            exercise.setMuscleGroupsWorked(exerciseDetails.getMuscleGroupsWorked());
            exercise.setSets(exerciseDetails.getSets());
            exercise.setReps(exerciseDetails.getReps());
            exercise.setWeight(exerciseDetails.getWeight());
            exercise.setLength(exerciseDetails.getLength());
            exercise.setDate(exerciseDetails.getDate());
    
            return exerciseRepository.save(exercise);
        }
        return null;
    }

    // DELETE
    public boolean deleteExercise(Long id) {
        if (exerciseRepository.existsById(id)) {
            exerciseRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // TODO: add more business logic as needed
}
