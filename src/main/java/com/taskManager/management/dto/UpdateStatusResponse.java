package com.taskManager.management.dto;

import com.taskManager.management.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateStatusResponse {
    private boolean success;
    private String message;
    private Task task;
}
