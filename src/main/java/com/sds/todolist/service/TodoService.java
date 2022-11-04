package com.sds.todolist.service;

import com.sds.todolist.domain.Task;
import com.sds.todolist.dto.TodoDto;
import com.sds.todolist.repository.TaskRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Service
public class TodoService {
    private final TaskRepository taskRepository;

    public TodoService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task creatTodo(TodoDto td){
        return taskRepository.save(td.toEntity());
    }

    public List<Task> readTodo(String owner, String orderBy) {
        if(Objects.equals(orderBy, "DESC")){
            return taskRepository.findAllByOwnerOrderByCreatedDateDesc(owner);
        }
        return taskRepository.findAllByOwnerOrderByCreatedDateAsc(owner);
    }

    public void updateTodo(Task task) {
        taskRepository.save(task);
    }

    public void deleteTodo(Long id) {
        Task task = taskRepository.findById(id).orElseThrow();
        task.setStatus("DELETED");
        taskRepository.save(task);
    }

    public void deleteAll(String owner) {
        List<Task> tasks = taskRepository.findAllByOwnerOrderByCreatedDateAsc(owner);
        for(Task task : tasks){
            task.setStatus("DELETED");
        }
        taskRepository.saveAll(tasks);
    }
}
