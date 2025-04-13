package com.myfitnessbuddy.app.controller;

import com.myfitnessbuddy.app.entity.FoodItem;
import com.myfitnessbuddy.app.service.FoodItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fooditems")
public class FoodItemController {

    @Autowired
    private FoodItemService foodItemService;

        // CREATE (Combined - creates from request body or fetches from USDA API)
        @PostMapping
        public ResponseEntity<FoodItem> createFoodItem(@RequestBody FoodItem foodItem) {
            FoodItem createdFoodItem;
            if (foodItem.getFoodName() != null && !foodItem.getFoodName().isEmpty()) {
                createdFoodItem = foodItemService.loadFoodItemFromUSDA(foodItem.getFoodName());
                if (createdFoodItem == null) {
                    createdFoodItem = foodItemService.createFoodItem(foodItem);
                }
            } else {
                // If no name, return bad request response
                return ResponseEntity.badRequest().body(null);
            }
            return ResponseEntity.status(201).body(createdFoodItem);
        }

    // READ
    // get food item by id
    @GetMapping("/{id}")
    public ResponseEntity<FoodItem> getFoodItemById(@PathVariable Long id) {
        FoodItem foodItem = foodItemService.getFoodItemById(id);
        return (foodItem != null) ? ResponseEntity.ok(foodItem) : ResponseEntity.notFound().build();
    }

    // get all food items
    @GetMapping
    public ResponseEntity<List<FoodItem>> getAllFoodItems() {
        List<FoodItem> foodItems = foodItemService.getAllFoodItems();
        return foodItems.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(foodItems);
    }

    // get food items by userId
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<FoodItem>> getFoodItemsByUserId(@PathVariable Long userId) {
        List<FoodItem> foodItems = foodItemService.getFoodItemsByUserId(userId);
        return foodItems.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(foodItems);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<FoodItem> updateFoodItem(@PathVariable Long id, @RequestBody FoodItem foodItemDetails) {
        FoodItem updatedFoodItem = foodItemService.updateFoodItem(id, foodItemDetails);
        return (updatedFoodItem != null) ? ResponseEntity.ok(updatedFoodItem) : ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFoodItem(@PathVariable Long id) {
        boolean deleted = foodItemService.deleteFoodItem(id);
        return deleted ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
