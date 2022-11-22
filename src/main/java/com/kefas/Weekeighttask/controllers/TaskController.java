package com.kefas.Weekeighttask.controllers;

import com.kefas.Weekeighttask.dto.TaskDto;
import com.kefas.Weekeighttask.entity.Task;
import com.kefas.Weekeighttask.exception.TaskAlreadyExistException;
import com.kefas.Weekeighttask.exception.TaskNotFoundException;
import com.kefas.Weekeighttask.service.serviceImpl.TaskServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1")
public class TaskController {

    private final TaskServiceImpl taskService;

    @PostMapping("/createTask")
    public ResponseEntity<String> createTask(@RequestBody TaskDto taskDto) throws TaskAlreadyExistException {
        return new ResponseEntity<>(taskService.createTask(taskDto), HttpStatus.ACCEPTED);
    }

    @PostMapping("/updateTask")
    public ResponseEntity<String> updateTask(@RequestBody TaskDto taskDto, Long id) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.updateTask(taskDto, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/getTaskByStatus")
    public ResponseEntity<List<Task>> getTask(@RequestBody TaskDto taskDto) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.viewAllTaskByStatus(taskDto), HttpStatus.ACCEPTED);
    }
    @GetMapping("/deleteTask")
    public ResponseEntity<String> deleteTask(@RequestBody TaskDto taskDto, Long id) throws TaskNotFoundException {
        return new ResponseEntity<>(taskService.deleteTask(taskDto, id), HttpStatus.ACCEPTED);
    }
}
