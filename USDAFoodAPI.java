import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class USDAFoodAPI {
    
    public static JSONObject searchFood(String foodName, String apiKey) throws Exception {

        String encodedFoodName = URLEncoder.encode(foodName, StandardCharsets.UTF_8.toString());
        
        //Print the encoded food name for debugging purposes
        //System.out.println("Encoded food name: " + encodedFoodName);

         //URL encode the food name to handle spaces and commas
        String urlString = "https://api.nal.usda.gov/fdc/v1/foods/search?query=" 
                            + encodedFoodName + "&api_key=" + apiKey;

        //Print the full URL for debugging purposes
        //System.out.println("Request URL: " + urlString);
        
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        //print response for debugging
        System.out.println("JSON Response: " + response.toString());


        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray foods = jsonResponse.optJSONArray("foods");

        if (foods != null && foods.length() > 0) {
            return foods.getJSONObject(0); //return first match
        }

        return null; //No results found
    }

    public static JSONObject getFoodDetails(int fdcId, String apiKey) throws Exception {
        String urlString = "https://api.nal.usda.gov/fdc/v1/food/" + fdcId + "?api_key=" + apiKey;
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }
        reader.close();

        return new JSONObject(response.toString());
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            //get user input for API key
            System.out.print("Enter your USDA API key: ");
            String apiKey = scanner.nextLine().trim();

            //get user input for food name
            System.out.print("Enter the food name: ");
            String foodName = scanner.nextLine();

            //fetch food details
            JSONObject foodItem = searchFood(foodName, apiKey);

            if (foodItem != null) {
                int fdcId = foodItem.getInt("fdcId");
                JSONObject details = getFoodDetails(fdcId, apiKey);

                JSONArray nutrients = details.getJSONArray("foodNutrients");
                double protein = 0, carbs = 0, fats = 0, sugar = 0;

                for (int i = 0; i < nutrients.length(); i++) {
                    JSONObject nutrient = nutrients.getJSONObject(i);
                    int nutrientId = nutrient.getInt("nutrientId");

                    switch (nutrientId) {
                        case 1003: 
                            protein = nutrient.getDouble("value");
                            break;
                        case 1005: 
                            carbs = nutrient.getDouble("value");
                            break;
                        case 1004:
                            fats = nutrient.getDouble("value");
                            break;
                        case 2000:
                            sugar = nutrient.getDouble("value");
                            break;
                    }
                }

                //nutrition information assuming request works
                System.out.println("\nNutritional Information for: " + foodName);
                System.out.println("Protein: " + protein + "g");
                System.out.println("Carbs: " + carbs + "g");
                System.out.println("Fats: " + fats + "g");
                System.out.println("Sugar: " + sugar + "g");
            } else {
                System.out.println("Food not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
