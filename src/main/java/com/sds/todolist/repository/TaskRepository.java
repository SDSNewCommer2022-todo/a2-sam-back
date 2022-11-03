package com.sds.todolist.repository;

import com.sds.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    public List<Task> findAllByOwnerOrderByCreatedDateAsc(String owner);
    public List<Task> findAllByOwnerOrderByCreatedDateDesc(String owner);


}
