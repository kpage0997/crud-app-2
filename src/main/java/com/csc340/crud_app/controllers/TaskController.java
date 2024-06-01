package com.csc340.crud_app.controllers;

import com.csc340.crud_app.Implement.GoalService;
import com.csc340.crud_app.models.Goal;
import com.csc340.crud_app.models.Task;
import com.csc340.crud_app.Implement.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Controller
@RequestMapping("/tasks")

public class TaskController {




    @Autowired
    private TaskService taskService;

    @Autowired
    private GoalService goalService;


    // Retrieve tasks by goal and return the tasks.html template


    // Retrieve tasks by status and return the tasks.html template
    @GetMapping("/status/{status}")

    public String getTasksByStatus(@PathVariable String status, Model model) {
        List<Task> tasks = taskService.getTasksByStatus(status);
        model.addAttribute("tasks", tasks);
        return "tasks_by_status";
    }

    // Retrieve a single task by its ID and return the task.html template
    @GetMapping("/{taskId}")

    public String getTaskById(@PathVariable int taskId, Model model) {
        Task task = taskService.getTask(taskId);
        model.addAttribute("task", task);
        return "task";
    }

    // Save(create) a new task and redirect to the tasks page
    @PostMapping("/create")

    public String createTask(@ModelAttribute Task task, @RequestParam int goalId) {
        task.setGoal(goalService.getGoal(goalId));
        taskService.saveTask(task);
        return "redirect:/tasks?goalId=" + goalId;
    }


    // Update an existing task and redirect to the tasks page
    @PutMapping("/update/{taskId}")

    public String updateTask(@PathVariable int taskId, @ModelAttribute Task task) {
        task.setTaskId(taskId);
        taskService.saveTask(task);
        return "redirect:/tasks";
    }


    // Delete a task by its ID and redirect to the tasks page
    @DeleteMapping("/delete/{taskId}")

    public String deleteTask(@PathVariable int taskId) {
        taskService.deleteTask(taskId);
        return "redirect:/tasks";
    }
}
