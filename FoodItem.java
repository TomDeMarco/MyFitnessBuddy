import java.util.HashMap;
import java.util.Map;


public class FoodItem {
    private String foodName;
    private double servingSize;
    private int caloriesPerServing;
    private double proteinAmount;
    private double carbAmount;
    private double fatAmount;
    private double sugarAmount;
    private String date;

    //API call to get all of this info. By doing it in the constructor we make our lives easier in the future.
    public FoodItem(String foodName, double servingSize, int caloriesPerServing, 
                    double proteinAmount, double carbAmount, double fatAmount, double sugarAmount, String date) {
        this.foodName = foodName;
        this.servingSize = servingSize;
        this.caloriesPerServing = caloriesPerServing;
        this.proteinAmount = proteinAmount;
        this.carbAmount = carbAmount;
        this.fatAmount = fatAmount;
        this.sugarAmount = sugarAmount;
        this.date = date;
    }

    public int calculateTotalCalories(double amount, String date) {
        //Calculates total calories based on the amount consumed.
        return 0;
    }

    public Map<String, Double> getNutrientBreakdown(double amount, String date) {
        //Retrieves adjusted macronutrient breakdown based on the portion consumed.
        return new HashMap<>();
    }
}

