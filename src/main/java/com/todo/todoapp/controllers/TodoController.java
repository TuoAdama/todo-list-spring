package com.todo.todoapp.controllers;

import com.todo.todoapp.enums.StatusEnum;
import com.todo.todoapp.models.Status;
import com.todo.todoapp.models.Todo;
import com.todo.todoapp.requests.TodoRequest;
import com.todo.todoapp.responses.TodoResponse;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<Todo> getById(
            @PathVariable("id") Long id
    ){
        Status status = new Status();
        status.setId(1L);
        status.setLabel("DONE");
        Todo todo = new Todo();
        todo.setId(id);
        todo.setTitle("todo 1");
        todo.setDescription("description 1");
        todo.setStatus(status);
        return ResponseEntity.status(HttpStatus.OK).body(todo);
    }

    @PostMapping
    public @ResponseBody ResponseEntity<TodoResponse> create(@RequestBody TodoRequest todoRequest){
        TodoResponse todoResponse = new TodoResponse(
                todoRequest.id(),
                todoRequest.title(),
                todoRequest.description(),
                todoRequest.status()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(todoResponse);
    }
}
