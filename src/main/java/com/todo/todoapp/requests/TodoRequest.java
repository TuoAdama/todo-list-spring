package com.todo.todoapp.requests;

public record TodoRequest(
        Long id,
        String title,
        String description,
        String status
){}
