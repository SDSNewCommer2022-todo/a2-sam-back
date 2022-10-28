package com.sds.todolist.controller;

import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.service.TodoService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class TodoController {
    final private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping(value="/todo")
    public Long create(@RequestBody TodoDto td){
        System.out.println(td.toString());
        return todoService.creatTodo(td);
    }
}
