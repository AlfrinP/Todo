package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public String todo() {
        return {"data":"the server is alive"};
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public String todoAll() {
        return
    }
}