package com.sds.todolist.controller;

import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.service.TodoService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@AllArgsConstructor
public class TodoController {
    final private TodoService todoService;

    @PostMapping(value="/todo")
    public Long create(@RequestBody TodoDto.TodoCreateRequest rq){
        System.out.println(rq.toString());
        return todoService.creatTodo(rq);
    }
}
