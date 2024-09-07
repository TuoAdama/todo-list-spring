package com.todo.todoapp.controllers;

import com.todo.todoapp.models.Todo;
import com.todo.todoapp.requests.TodoRequest;
import com.todo.todoapp.responses.TodoResponse;
import com.todo.todoapp.services.TodoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    private final TodoService todoService;

    TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Todo> getById(
            @PathVariable("id") Long id
    ){
        var todo = todoService.find(id);
        if (todo == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.status(HttpStatus.OK).body(
                todoService.find(id)
        );
    }

    @PostMapping
    public @ResponseBody ResponseEntity<TodoResponse> create(@RequestBody TodoRequest todoRequest){
        Todo todo = todoService.create(todoRequest);
        TodoResponse todoResponse = new TodoResponse(
                todo.getId(),
                todo.getTitle(),
                todo.getDescription(),
                todo.getStatus()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponse);
    }
}
