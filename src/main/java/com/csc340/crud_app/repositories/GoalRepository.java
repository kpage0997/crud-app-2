package com.csc340.crud_app.repositories;

import com.csc340.crud_app.models.Goal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Integer> {
    // Custom query to find goals by user ID
    public List<Goal> findByUserId(@Param("userId") int userId);
}
