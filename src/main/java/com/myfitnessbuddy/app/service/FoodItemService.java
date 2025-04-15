package com.myfitnessbuddy.app.service;

import com.myfitnessbuddy.app.entity.FoodItem;
import com.myfitnessbuddy.app.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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

    //CREATE USING USDA
    public FoodItem createFoodItemFromUSDA(String foodName){
        try{
            FoodItem foodItem = loadFoodItemFromUSDA(foodName);
            if(foodItem != null){
                return foodItemRepository.save(foodItem);
            }
        } catch (Exception e){
            e.printStackTrace();
            
        }
        return new FoodItem(null, foodName, 0, -1, -1, -1, -1, -1, null);
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

    // Factory method to create a FoodItem from USDA API
    public FoodItem loadFoodItemFromUSDA(String name) {
        try {
            // Fetch the nutritional data from USDA API
            USDAFoodAPI api = new USDAFoodAPI();
            String apiKey = api.getApiKey();
            Double proteinAmount = api.getProtein(name, apiKey);
            Double carbAmount = api.getCarbs(name, apiKey);
            Double fatAmount = api.getFats(name, apiKey);
            Double sugarAmount = api.getSugar(name, apiKey);
            int caloriesPerServing = (int) Math.round(api.getCalories(name, apiKey));

            // Create and return a new FoodItem with the fetched data
            FoodItem foodItem = new FoodItem();
            foodItem.setFoodName(name);
            foodItem.setProteinAmount(proteinAmount);
            foodItem.setCarbAmount(carbAmount);
            foodItem.setFatAmount(fatAmount);
            foodItem.setSugarAmount(sugarAmount);
            foodItem.setCaloriesPerServing(caloriesPerServing);
            foodItem.setDate(foodItem.getDate());

            return foodItem;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    
    
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
