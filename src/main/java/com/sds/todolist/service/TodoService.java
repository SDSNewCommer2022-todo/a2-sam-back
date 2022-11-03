package com.sds.todolist.service;

import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task creatTodo(TodoDto td){
        return taskRepository.save(td.toEntity());
    }

    public List<Task> readTodo(String owner) {
        List<Task> tasks = new ArrayList<Task>();
        return taskRepository.findAllByOwner(owner);
    }

    public void updateTodo(Task task) {
        taskRepository.save(task);
    }
}
