package com.example.todo.service;

import com.example.todo.model.Todo;
import com.example.todo.repo.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;


    public List<Todo> getAllTask() {
        return todoRepository.findAll();
    }


    public Optional<Todo> getTaskById(long id) {
        return todoRepository.findById(id);
    }


    public String updateTask(long id, Todo updatedTodo) {
        Optional<Todo> existingTodoOptional = todoRepository.findById(id);
        if (existingTodoOptional.isPresent()) {
            Todo existingTodo = existingTodoOptional.get();

            if (updatedTodo.getName() != null) {
                existingTodo.setName(updatedTodo.getName());
            }
            if (updatedTodo.getDescription() != null) {
                existingTodo.setDescription(updatedTodo.getDescription());
            }
            if (updatedTodo.getStatus() != null) {
                existingTodo.setStatus(updatedTodo.getStatus());
            }

            todoRepository.save(existingTodo);
            return "Task updated successfully.";
        } else {
            return "Task not found.";
        }
    }



    public String deleteTask(long id) {
        if (todoRepository.existsById(id)) {
            todoRepository.deleteById(id);
            return "Task deleted successfully.";
        } else {
            return "Task not found.";
        }
    }
}
