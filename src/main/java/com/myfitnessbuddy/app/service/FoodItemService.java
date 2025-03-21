package com.myfitnessbuddy.app.service;

import com.myfitnessbuddy.app.entity.User;
import com.myfitnessbuddy.app.entity.FoodItem;
import com.myfitnessbuddy.app.repository.FoodItemRepository;
import com.myfitnessbuddy.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodItemService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    // Basic CRUD ops below :)
    // CREATE
    // creates a new food item
    public FoodItem createFoodItem(FoodItem foodItem) {
        return foodItemRepository.save(foodItem);
    }

    // READ
    // gets fooditem by id
    public FoodItem getFoodItemById(Long id) {
        return foodItemRepository.findById(id).orElse(null);
    }

    // get all fooditems in db table
    public List<FoodItem> getAllFoodItems() {
        return foodItemRepository.findAll();
    }

    // gets list of food items associated with a given user id
    public List<FoodItem> getFoodItemsByUserId(Long userId) {
        return foodItemRepository.findByUserId(userId);
    }

    // UPDATE
    // update food item's details
    public FoodItem updateFoodItem(Long id, FoodItem foodItemDetails) {
        Optional<FoodItem> optionalFoodItem = foodItemRepository.findById(id);

        if (optionalFoodItem.isPresent()) {
            FoodItem foodItem = optionalFoodItem.get();
    
            // Update fields — but do not touch the user
            foodItem.setFoodName(foodItemDetails.getFoodName());
            foodItem.setServingSize(foodItemDetails.getServingSize());
            foodItem.setCaloriesPerServing(foodItemDetails.getCaloriesPerServing());
            foodItem.setProteinAmount(foodItemDetails.getProteinAmount());
            foodItem.setCarbAmount(foodItemDetails.getCarbAmount());
            foodItem.setFatAmount(foodItemDetails.getFatAmount());
            foodItem.setSugarAmount(foodItemDetails.getSugarAmount());
            foodItem.setDate(foodItemDetails.getDate());
    
            return foodItemRepository.save(foodItem);
        }
        return null;
    }

    // DELETE
    public boolean deleteFoodItem(Long id) {
        if (foodItemRepository.existsById(id)) {
            foodItemRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // TODO: implement service methods
    // Factory method to create a FoodItem from USDA API
    // public static FoodItem loadFoodItemFromUSDA(String foodName, String apiKey) {
    //     try {
    //         JSONObject foodData = USDAFoodAPI.searchFood(foodName, apiKey);
    //         if (foodData == null) {
    //             return null;
    //         }

    //         double servingSize = 100.0; // Assume 100g serving if not provided
    //         int calories = USDAFoodAPI.getCalories(foodName, apiKey).intValue();
    //         double protein = USDAFoodAPI.getProtein(foodName, apiKey);
    //         double carbs = USDAFoodAPI.getCarbs(foodName, apiKey);
    //         double fats = USDAFoodAPI.getFats(foodName, apiKey);
    //         double sugar = USDAFoodAPI.getSugar(foodName, apiKey);

    //         return new FoodItem(foodName, servingSize, calories, protein, carbs, fats, sugar, "2025-03-11");
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }

    // public int calculateTotalCalories(double amount, String date) {
    //     return (int) ((amount / servingSize) * caloriesPerServing);
    // }

    // public Map<String, Double> calculateNutrientBreakdown(double amount, String date) {
    //     Map<String, Double> breakdown = new HashMap<>();
    //     breakdown.put("Protein", (amount / servingSize) * proteinAmount);
    //     breakdown.put("Carbohydrates", (amount / servingSize) * carbAmount);
    //     breakdown.put("Fats", (amount / servingSize) * fatAmount);
    //     breakdown.put("Sugar", (amount / servingSize) * sugarAmount);
    //     return breakdown;
    // }

}
