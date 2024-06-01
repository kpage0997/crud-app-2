package com.csc340.crud_app.controllers;

import com.csc340.crud_app.models.Goal;
import com.csc340.crud_app.Implement.GoalService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

@RequestMapping("/goals")
public class GoalController {




    // Constructor for GoalController using dependency injection
    @Autowired
    private GoalService goalService;


    // Retrieve all goals for a specific user and display them in a view

    @GetMapping("/all")
    public String getAllGoals(@RequestParam int userId, Model model) {
        List<Goal> goals = goalService.getAllGoals(userId);
        model.addAttribute("goals", goals);
        return "goals";
    }


    // Retrieve a single goal by its ID and display it in a view
    @GetMapping("/{goalId}")


    public String getGoal(@PathVariable int goalId, Model model) {
        Goal goal = goalService.getGoal(goalId);
        model.addAttribute("goal", goal);
        return "goal";
    }

    // Save a new goal(create) and redirect to the goals page
    @PostMapping("/create")

    public String saveGoal(@ModelAttribute Goal goal) {
        goalService.saveGoal(goal);
        return "create_goal";
    }


    // Update an existing goal and redirect to the goals page
    @PutMapping("/goals/update/{goalId}")

    public String updateGoal(@PathVariable int goalId, @ModelAttribute Goal goal) {
        goal.setGoalId(goalId);
        goalService.saveGoal(goal);
        return "redirect:/goals";
    }


    // Delete a goal and redirect to the goals page
    @DeleteMapping("/goals/delete/{goalId}")

    public String deleteGoal(@PathVariable int goalId) {
        goalService.deleteGoal(goalId);
        return "redirect:/goals";
    }
}
