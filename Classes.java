public class Exercise {
    private String exerciseName;
    private List<String> muscleGroupsWorked;
    private int sets;
    private int reps;
    private int length;
    private String date;

    public Exercise(String exerciseName, List<String> muscleGroupsWorked, int sets, int reps, int length, String date) {
        this.exerciseName = exerciseName;
        this.muscleGroupsWorked = muscleGroupsWorked;
        this.sets = sets;
        this.reps = reps;
        this.length = length;
        this.date = date;
    }
}

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