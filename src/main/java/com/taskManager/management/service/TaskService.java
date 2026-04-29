package com.taskManager.management.service;

import com.taskManager.management.dto.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface TaskService {
    TaskResponse createTask(CreateTaskRequest createTaskRequest);
    TaskResponse getTask(Long taskId);
    TaskResponse retrieveAllTasks();
    UpdateStatusResponse updateStatus(Long taskId,UpdateStatusRequest UpdateStatusRequest);
    UpdateTaskResponse taskUpdate(Long taskId, CreateTaskRequest update);
}
