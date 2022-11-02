package com.sds.todolist.controller;

import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/api")
public class TodoController {
    final private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping(value="/post")
    public Task create(@RequestBody TodoDto td){
        return todoService.creatTodo(td);
    }

    @GetMapping(value = "/todo")
    public List<Task> read(@RequestParam("owner")String owner){
        return todoService.readTodo(owner);
    }
}
