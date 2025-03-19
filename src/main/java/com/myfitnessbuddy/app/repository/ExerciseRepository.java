package com.myfitnessbuddy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitnessbuddy.app.entity.Exercise;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{

}
