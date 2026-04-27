package com.taskManager.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponse {
    private boolean success;
    private String message;
    private TaskDto task;
}
