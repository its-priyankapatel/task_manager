package com.taskManager.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskResponse {
    private boolean success;
    private String message;
    private List<TaskDto> task = new ArrayList<>();
}
