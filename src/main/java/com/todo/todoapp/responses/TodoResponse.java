package com.todo.todoapp.responses;

public record TodoResponse(
        Long id,
        String title,
        String description,
        String status
) {
}
