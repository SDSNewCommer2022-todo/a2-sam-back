package com.sds.todolist.dto;

import com.sds.todolist.domain.Task;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

public class TodoDto {


    @Getter
    @AllArgsConstructor
    @ToString
    public static class TodoCreateRequest {
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
}
