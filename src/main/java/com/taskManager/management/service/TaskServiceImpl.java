package com.taskManager.management.service;

import com.taskManager.management.Exception.InvalidException;
import com.taskManager.management.dto.CreateTaskRequest;
import com.taskManager.management.dto.TaskDto;
import com.taskManager.management.dto.TaskResponse;
import com.taskManager.management.model.Task;
import com.taskManager.management.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    public TaskServiceImpl(TaskRepository taskRepository)
    {
        this.taskRepository=taskRepository;
    }

    @Override
    public TaskResponse createTask(CreateTaskRequest createTaskRequest) {

       Task newTask=new Task();
       newTask.setTitle(createTaskRequest.getTitle());
       newTask.setDescription(createTaskRequest.getDescription());
       newTask.setStatus("PENDING");

       Task task = taskRepository.save(newTask);

       return new TaskResponse(true,"task created successfully",mapToDto(task));
    }

    private TaskDto mapToDto(Task task)
    {
        return new TaskDto(
         task.getId(), task.getTitle(), task.getDescription(), task.getStatus()
        );
    }
}
