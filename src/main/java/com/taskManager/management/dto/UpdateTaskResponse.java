package com.taskManager.management.dto;

import com.taskManager.management.model.Task;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UpdateTaskResponse {
  private boolean success;
  private String message;
  private Task task;
}
