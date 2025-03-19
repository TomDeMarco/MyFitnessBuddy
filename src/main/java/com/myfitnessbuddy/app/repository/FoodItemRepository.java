package com.myfitnessbuddy.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.myfitnessbuddy.app.entity.FoodItem;
import com.myfitnessbuddy.app.entity.User;
import java.util.List;

public interface FoodItemRepository extends JpaRepository<FoodItem, Long>{
    // Find all food items for a specific user
    List<FoodItem> findByUser(User user);
}
