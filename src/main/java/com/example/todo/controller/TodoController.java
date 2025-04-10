package com.example.todo.controller;

import com.example.todo.model.Todo;
import com.example.todo.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@RestController
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("The server is alive");
    }

    @GetMapping("/allTask")
    public ResponseEntity<List<Todo>> allTasks() {
        return ResponseEntity.ok(todoService.getAllTask());
    }

    @GetMapping("/task")
    public ResponseEntity<Todo> getTaskById(@RequestParam long id) {
        Optional<Todo> todo = todoService.getTaskById(id);
        return todo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/task")
    public ResponseEntity<String> createOrUpdateTask(@RequestBody Todo updatedTodo, @RequestParam long id) {
        String result = todoService.updateTask(id, updatedTodo);
        if (result.equals("Task updated successfully.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);
        }
    }

    @DeleteMapping("/task")
    public ResponseEntity<String> deleteTask(@RequestParam long id) {
        String result = todoService.deleteTask(id);
        if (result.equals("Task deleted successfully.")) {
            return ResponseEntity.ok(result);
        } else {
            return ResponseEntity.status(404).body(result);
        }
    }
}
