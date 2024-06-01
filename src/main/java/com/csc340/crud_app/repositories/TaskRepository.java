package com.csc340.crud_app.repositories;

import com.csc340.crud_app.models.Goal;
import com.csc340.crud_app.models.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {
    // Custom query to find tasks by goal
    @Query("SELECT t FROM Task t WHERE t.goal.goalId = :goalId")
    public List<Task> findByGoalId(@Param("goalId") int goalId);

    // Custom query to find tasks by status
    @Query("SELECT t FROM Task t WHERE t.status = :status")
    public List<Task> findByStatus(@Param("status") String status);



}
