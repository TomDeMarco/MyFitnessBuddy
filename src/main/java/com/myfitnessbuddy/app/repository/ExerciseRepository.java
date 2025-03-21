package com.myfitnessbuddy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitnessbuddy.app.entity.Exercise;
import com.myfitnessbuddy.app.entity.User;
import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long>{
    List<Exercise> findByUser(User user);
}
