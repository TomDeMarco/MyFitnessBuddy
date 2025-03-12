import java.util.HashMap;
import java.util.Map;
import org.json.*;

public class FoodItem {
    private String foodName;
    private double servingSize;
    private int caloriesPerServing;
    private double proteinAmount;
    private double carbAmount;
    private double fatAmount;
    private double sugarAmount;
    private String date;

    // Constructor
    public FoodItem(String foodName, double servingSize, int caloriesPerServing, 
                    double proteinAmount, double carbAmount, double fatAmount, 
                    double sugarAmount, String date) {
        this.foodName = foodName;
        this.servingSize = servingSize;
        this.caloriesPerServing = caloriesPerServing;
        this.proteinAmount = proteinAmount;
        this.carbAmount = carbAmount;
        this.fatAmount = fatAmount;
        this.sugarAmount = sugarAmount;
        this.date = date;
    }

    // Factory method to create a FoodItem from USDA API
    public static FoodItem createFromUSDA(String foodName, String apiKey) {
        try {
            JSONObject foodData = USDAFoodAPI.searchFood(foodName, apiKey);
            if (foodData == null) {
                return null;
            }

            double servingSize = 100.0; // Assume 100g serving if not provided
            int calories = USDAFoodAPI.getCalories(foodName, apiKey).intValue();
            double protein = USDAFoodAPI.getProtein(foodName, apiKey);
            double carbs = USDAFoodAPI.getCarbs(foodName, apiKey);
            double fats = USDAFoodAPI.getFats(foodName, apiKey);
            double sugar = USDAFoodAPI.getSugar(foodName, apiKey);

            return new FoodItem(foodName, servingSize, calories, protein, carbs, fats, sugar, "2025-03-11");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int calculateTotalCalories(double amount, String date) {
        return (int) ((amount / servingSize) * caloriesPerServing);
    }

    public Map<String, Double> getNutrientBreakdown(double amount, String date) {
        Map<String, Double> breakdown = new HashMap<>();
        breakdown.put("Protein", (amount / servingSize) * proteinAmount);
        breakdown.put("Carbohydrates", (amount / servingSize) * carbAmount);
        breakdown.put("Fats", (amount / servingSize) * fatAmount);
        breakdown.put("Sugar", (amount / servingSize) * sugarAmount);
        return breakdown;
    }

    public String getFoodName() { return foodName; }
    public double getServingSize() { return servingSize; }
    public int getCaloriesPerServing() { return caloriesPerServing; }
    public double getProteinAmount() { return proteinAmount; }
    public double getCarbAmount() { return carbAmount; }
    public double getFatAmount() { return fatAmount; }
    public double getSugarAmount() { return sugarAmount; }
}
