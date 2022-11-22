package com.kefas.Weekeighttask.service;

import com.kefas.Weekeighttask.dto.TaskDto;
import com.kefas.Weekeighttask.entity.Task;
import com.kefas.Weekeighttask.exception.TaskAlreadyExistException;
import com.kefas.Weekeighttask.exception.TaskNotFoundException;
import java.util.List;

public interface TaskService {

    String createTask(TaskDto taskDto) throws TaskAlreadyExistException;
    String updateTask(TaskDto taskDto,Long id) throws TaskNotFoundException;
    String deleteTask(TaskDto taskDto,Long id) throws TaskNotFoundException;
    List<Task> viewAllTaskByStatus(TaskDto taskDto) throws TaskNotFoundException;

}
