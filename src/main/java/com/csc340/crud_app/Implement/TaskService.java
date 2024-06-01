package com.csc340.crud_app.Implement;

import com.csc340.crud_app.models.Task;
import com.csc340.crud_app.repositories.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {


    @Autowired
    TaskRepository taskRepository;


    // Retrieve tasks by goal using custom query from repository


    // Retrieve tasks by status using custom query from repository
    public List<Task> getTasksByStatus(String status) {
        return taskRepository.findByStatus(status);
    }

    // Retrieve a single task by its ID
    public Task getTask(int taskId) {
        return taskRepository.findById(taskId).orElse(null);
    }


    // Create or update a task
    public Task saveTask(Task task) {
        return taskRepository.save(task);

    }

    // Delete a task by its ID
    public void deleteTask(int taskId) {
        taskRepository.deleteById(taskId);
    }
}
