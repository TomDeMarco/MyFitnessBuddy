import java.util.ArrayList;
import java.util.List;


public class User {
    private String name;
    private int age;
    private double weight;
    private double height;
    private String fitnessGoals;
    private String gender;
    private List<FoodItem> historicalFood;
    private List<Exercise> historicalExercises;

    public User(String name, int age, double weight, double height, String fitnessGoals, String gender) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
        this.fitnessGoals = fitnessGoals;
        this.gender = gender;
        this.historicalFood = new ArrayList<>();
        this.historicalExercises = new ArrayList<>();
    }

    public void logDailyCalories(FoodItem foodItem) {
        //Stores user calorie intake for a specific day.
    }

    public void logWorkout(Exercise exercise) {
        //Logs a completed workout session.
    }

    public List<FoodItem> getHistoricalCalories(String startDate, String endDate) {
        //Retrieves user calorie intake history for a given time range.
        return new ArrayList<>();
    }

    public List<Exercise> getHistoricalWorkouts(String startDate, String endDate) {
        //Retrieves user workout history for a given time range.
        return new ArrayList<>();
    }
}