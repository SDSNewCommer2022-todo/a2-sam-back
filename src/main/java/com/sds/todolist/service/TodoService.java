package com.sds.todolist.service;

import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Long creatTodo(TodoDto.TodoCreateRequest rq){
        Task task = taskRepository.save(rq.toEntity());
        return task.getId();
    }
}

