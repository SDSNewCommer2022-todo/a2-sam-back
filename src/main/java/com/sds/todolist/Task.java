package com.sds.todolist;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(length = 20)
    private String owner;

    @Column(length = 100, columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(length = 20)
    private String status;

    @Column(nullable = false)
    private LocalDateTime created_date;

    @Column(nullable = false)
    private LocalDateTime modified_date;

    enum status {
        COMPLETED,
        REGISTERED,
        DELETED
    }
}
