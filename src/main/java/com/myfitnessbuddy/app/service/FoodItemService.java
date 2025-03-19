package com.myfitnessbuddy.app.service;

public class FoodItemService {
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
