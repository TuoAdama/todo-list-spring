package com.todo.todoapp.services;

import com.todo.todoapp.models.Todo;
import com.todo.todoapp.repositories.TodoRepository;
import com.todo.todoapp.requests.TodoRequest;
import com.todo.todoapp.responses.TodoResponse;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    private TodoRepository todoRepository;

    public TodoService(
            TodoRepository todoRepository
    ){
        this.todoRepository = todoRepository;
    }

    public Todo create(TodoRequest todoRequest){
        Todo todo = new Todo();
        todo.setTitle(todoRequest.title());
        todo.setDescription(todoRequest.description());
        todo.setStatus(todoRequest.status());
        todoRepository.save(todo);
        return todo;
    }

    public Todo find(Long id) {
        return todoRepository.findById(id).orElse(null);
    }
}
