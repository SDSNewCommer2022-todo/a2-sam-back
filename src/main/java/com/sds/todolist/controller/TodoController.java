package com.sds.todolist.controller;

import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.service.TodoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@CrossOrigin
@RequestMapping(value = "/todo")
public class TodoController {
    final private TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @PostMapping
    public Task create(@RequestBody TodoDto td){
        return todoService.creatTodo(td);
    }

    @GetMapping
    public List<Task> read(@RequestParam("owner")String owner,@RequestParam("orderBy")String orderBy){
        return todoService.readTodo(owner,orderBy);
    }

    @PatchMapping
    public void update(@RequestBody Task t){
        todoService.updateTodo(t);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id")Long id){
        todoService.deleteTodo(id);
    }

    @DeleteMapping  
    public void deleteAll(@RequestParam("owner")String owner){
        todoService.deleteAll(owner);
    }
}
