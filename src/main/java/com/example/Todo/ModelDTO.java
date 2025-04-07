package com.example.Todo.dto;

public class TodoResponse {

    private String name; // Corrected from "Sting namel" to "String name"
    private int id;
    private String status;

    // Default Constructor
    public TodoResponse() {}

    // Parameterized Constructor
    public TodoResponse(String name, int id, String status) {
        this.name = name;
        this.id = id;
        this.status = status;
    }

    // Getters and Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}