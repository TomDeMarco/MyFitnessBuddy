package com.myfitnessbuddy.app.service;

import com.myfitnessbuddy.app.entity.User;
// import com.myfitnessbuddy.app.entity.Exercise;
// import com.myfitnessbuddy.app.entity.FoodItem;
import com.myfitnessbuddy.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// service annotation tells spring to create object of this class
// service layers handles the business logic that bridges data layer (repository) with API layer (controllers)
@Service
public class UserService {

    // internally creates repository to inject users into
    @Autowired
    private UserRepository userRepository;

    // CREATE
    // creates a new user with a correpsonding id
    public User createUser(User user) {
        return userRepository.save(user);
    }

    // READ
    // gets a user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    // get all users in the db table
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // UPDATE
    // update user's details
    public User updateUser(Long id, User userDetails) {
        // gets user by id
        // Optional<User> prevents a 
        Optional<User> optionalUser = userRepository.findById(id);
        // makes sure user is present before fetching details to update
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDetails.getName());
            user.setAge(userDetails.getAge());
            user.setWeight(userDetails.getWeight());
            user.setHeight(userDetails.getHeight());
            user.setFitnessGoals(userDetails.getFitnessGoals());
            user.setGender(userDetails.getGender());
            return userRepository.save(user);
        }
        return null;
    }

    // DELETE
    // deletes a user
    public boolean deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // TODO: Implement Methods with new architecture
    // should these be here or somewhere else?
    // public void logDailyCalories(FoodItem foodItem) {
    //     this.historicalFood.add(foodItem);
    // }

    // public void logWorkout(Exercise exercise) {
    //     this.historicalExercises.add(exercise);
    // }

    // public List<FoodItem> getHistoricalCalories(String startDate, String endDate) {
    //     return new ArrayList<>();
    // }

    // public List<Exercise> getHistoricalWorkouts(String startDate, String endDate) {
    //     return new ArrayList<>();
    // }
}