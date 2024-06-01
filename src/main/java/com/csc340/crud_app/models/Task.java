package com.csc340.crud_app.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int taskId;

    @ManyToOne
    @JoinColumn(name = "goalId", nullable = false)
    private Goal goal;

    @NonNull
    private String title;


    private String details;


    private String status;


}
