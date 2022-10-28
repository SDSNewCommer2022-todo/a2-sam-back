package com.sds.todolist.dto;

import com.sds.todolist.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@Getter
@AllArgsConstructor
@ToString
public class TodoDto {
    private String owner;
    private String content;
    private String status;

    public Task toEntity() {
        return Task.builder().
                owner(this.owner).
                content(this.content).
                status("test").
                build();
    }
}
