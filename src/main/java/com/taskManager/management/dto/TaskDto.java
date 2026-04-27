package com.taskManager.management.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    private String status;
}
