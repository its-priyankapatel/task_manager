package com.taskManager.management.service;

import com.taskManager.management.Exception.InvalidException;
import com.taskManager.management.dto.*;
import com.taskManager.management.model.Task;
import com.taskManager.management.repository.TaskRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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

       return new TaskResponse(true,"task created successfully",mapToDto(List.of(task)));
    }

    @Override
    public TaskResponse getTask(Long taskId)
    {
        Optional<Task> task = taskRepository.findById(taskId);
        if(!task.isPresent())
        {
          throw new InvalidException("Task is not found");
        }

        return new TaskResponse(true,"Task get successfully",mapToDto(List.of(task.get())));
    }

    @Override
    public TaskResponse retrieveAllTasks()
    {
        List<Task> allTask = taskRepository.findAll();
        return new TaskResponse(true,"All tasks retrieve successfully",mapToDto(allTask));
    }

    @Override
    public UpdateStatusResponse updateStatus(Long taskId,UpdateStatusRequest updateStatusRequest)
    {
       Optional<Task>isTaskExist =taskRepository.findById(taskId);
       if(!isTaskExist.isPresent())
       {
           throw new InvalidException("Task is not exist");
       }

       String newStatus= updateStatusRequest.getStatus().toUpperCase();
       if(!newStatus.equals("PENDING") && !newStatus.equals("IN_PROGRESS") && !newStatus.equals("COMPLETED"))
       {
           throw new InvalidException("Invalid Status value");
       }
       isTaskExist.get().setStatus(newStatus);
       Task task = taskRepository.save(isTaskExist.get());
       return new UpdateStatusResponse(true,"Status updated successfully",task);
    }

    @Override
    public UpdateTaskResponse taskUpdate(Long taskId,CreateTaskRequest update)
    {
    Optional<Task> task= taskRepository.findById(taskId);
    if(!task.isPresent())
    {
        throw new InvalidException("Task is not found");
    }
    Task newTask=task.get();
    newTask.setTitle(update.getTitle());
    newTask.setDescription(update.getDescription());
    newTask.setStatus(update.getStatus());
    Task updatedTask = taskRepository.save(newTask);
    return new UpdateTaskResponse(true,"Task updated Successfully",updatedTask);
    }

    private List<TaskDto> mapToDto(List<Task> tasks)
    {

        List<TaskDto> taskDtoList = new ArrayList<>();
        for(Task val:tasks) {
            TaskDto taskDto = new TaskDto(
                    val.getId(), val.getTitle(), val.getDescription(), val.getStatus()
            );
            taskDtoList.add(taskDto);
        }
        return taskDtoList;
    }
}
