package com.taskManager.management.service;

import com.taskManager.management.dto.CreateTaskRequest;
import com.taskManager.management.dto.TaskResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(CreateTaskRequest createTaskRequest);
    TaskResponse getTask(Long taskId);
    TaskResponse retrieveAllTasks();

}
