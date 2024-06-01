package com.csc340.crud_app.Implement;

import com.csc340.crud_app.models.Goal;
import com.csc340.crud_app.repositories.GoalRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoalService {

    @Autowired
    GoalRepository goalRepository;

    // Retrieve all goals for a specific user using custom query from repository
    public List<Goal> getAllGoals(int userId) {
        return goalRepository.findByUserId(userId);
    }

    // Retrieve a single goal by its ID
    public Goal getGoal(int goalId) {
        return goalRepository.findById(goalId).orElse(null);
    }

    // Create or update a goal
    public Goal saveGoal(Goal goal) {
        goalRepository.save(goal);
        return goal;
    }

    // Delete a goal by its ID
    public void deleteGoal(int goalId) {
        goalRepository.deleteById(goalId);
    }
}
