package com.myfitnessbuddy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitnessbuddy.app.entity.Exercise;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
    // find all exercises for a specific user by user id
    List<Exercise> findByUserId(Long userId);
}
