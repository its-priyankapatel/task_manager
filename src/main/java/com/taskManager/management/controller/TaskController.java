package com.taskManager.management.controller;

import com.taskManager.management.dto.*;
import com.taskManager.management.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
   private final TaskService taskService;
   public TaskController(TaskService taskService)
   {
       this.taskService=taskService;
   }

   @PostMapping("/create-task")
   ResponseEntity<TaskResponse>taskCreate(@RequestBody CreateTaskRequest createTaskRequest)
   {
       TaskResponse response = taskService.createTask(createTaskRequest);
       return ResponseEntity.status(HttpStatus.CREATED).body(response);
   }

   @GetMapping("/get-task")
    ResponseEntity<TaskResponse>getATask(@RequestParam Long taskId)
   {
      TaskResponse response = taskService.getTask(taskId);
      return ResponseEntity.status(HttpStatus.OK).body(response);
   }

   @GetMapping("/get-all-tasks")
    ResponseEntity<List<TaskResponse>> getAllTask()
   {
       TaskResponse response= taskService.retrieveAllTasks();
       return ResponseEntity.status(HttpStatus.OK).body(List.of(response));
   }

   @PatchMapping("/update-status/{taskId}")
    ResponseEntity<UpdateStatusResponse>changeStatus(@PathVariable Long taskId,@RequestBody UpdateStatusRequest updateStatusRequest)
   {
       UpdateStatusResponse response= taskService.updateStatus(taskId,updateStatusRequest);
       return ResponseEntity.status(HttpStatus.OK).body(response);
   }

   @PutMapping("/update-task")
    ResponseEntity<UpdateTaskResponse> updateTask(@RequestParam Long taskId, @RequestBody CreateTaskRequest update)
   {
       UpdateTaskResponse response = taskService.taskUpdate(taskId,update);
       return ResponseEntity.status(HttpStatus.OK).body(response);
   }
}
