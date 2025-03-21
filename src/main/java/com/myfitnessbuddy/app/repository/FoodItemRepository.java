package com.myfitnessbuddy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitnessbuddy.app.entity.FoodItem;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{
    // find all food items for a specific user by user id
    List<FoodItem> findByUserId(Long userId);
}
