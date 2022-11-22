package com.kefas.Weekeighttask.service.serviceImpl;

import com.kefas.Weekeighttask.dto.TaskDto;
import com.kefas.Weekeighttask.entity.Task;
import com.kefas.Weekeighttask.exception.TaskAlreadyExistException;
import com.kefas.Weekeighttask.exception.TaskNotFoundException;
import com.kefas.Weekeighttask.repository.TaskRepository;
import com.kefas.Weekeighttask.service.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Override
    public String createTask(TaskDto taskDto) throws TaskAlreadyExistException {
        Task task = new Task();
        boolean existTaskByTitle = taskRepository.findTaskByTitle(taskDto.getTitle()).isPresent();
        if(existTaskByTitle){
            throw new TaskAlreadyExistException("This task Already Exist create new one");
        }
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setStatus("Todo");
        taskRepository.save(task);
        return "Task Created Successfully";
    }

    @Override
    public String updateTask(TaskDto taskDto, Long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).
                orElseThrow(()-> new TaskNotFoundException("Task Not Found"));
        task.setStatus(taskDto.getStatus());
        taskRepository.save(task);
        return "Task Updated Successfully";
    }

    @Override
    public String deleteTask(TaskDto taskDto, Long id) throws TaskNotFoundException {
        Task task = taskRepository.findById(id).
                orElseThrow(()-> new TaskNotFoundException("Task Not Found"));
        task.setStatus(taskDto.getStatus());
        taskRepository.delete(task);
        return "Task Deleted Successfully";
    }

    @Override
    public List<Task> viewAllTaskByStatus(TaskDto taskDto) throws TaskNotFoundException {
        Task task = taskRepository.findTaskByStatus(taskDto.getStatus()).
                orElseThrow(()-> new TaskNotFoundException("Task Not Found"));
        List<Task> allPendingTask = new ArrayList<>();
        allPendingTask.add(task);
        return  allPendingTask;
    }
}
