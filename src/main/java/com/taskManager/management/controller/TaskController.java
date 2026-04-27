package com.taskManager.management.controller;

import com.taskManager.management.dto.CreateTaskRequest;
import com.taskManager.management.dto.TaskResponse;
import com.taskManager.management.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
