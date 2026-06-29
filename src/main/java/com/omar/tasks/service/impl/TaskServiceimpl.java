package com.omar.tasks.service.impl;

import com.omar.tasks.domain.CreatetaskRequest;
import com.omar.tasks.domain.entity.Task;
import com.omar.tasks.domain.entity.TaskStatus;
import com.omar.tasks.domain.entity.UpdateTaskRequest;
import com.omar.tasks.exception.TaskNotFoundException;
import com.omar.tasks.repository.TaskRepository;
import com.omar.tasks.service.TaskService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
public class TaskServiceimpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceimpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public Task createTask(CreatetaskRequest request) {
        Instant now=    Instant.now();
        Task task = new Task(
               null,
               request.title(),
               request.description(),
               request.dueDate(),
                request.priority(),
                TaskStatus.OPEN,
                now,
                now

        );

        return taskRepository.save(task);
    }

    @Override
    public List<Task> findAllTasks() {
        return taskRepository.findAll(Sort.by("created").descending());
    }

    @Override
    public Task updateTask(UUID taskId, UpdateTaskRequest request) {
        Task task=taskRepository.findById(taskId).orElseThrow(()-> new  TaskNotFoundException(taskId));
        task.setTitle(request.title());
        task.setDescription(request.description());
        task.setDueDate(request.duedate());
        task.setPriority(request.priority());
        task.setStatus(request.status());
        return  taskRepository.save(task);
    }

    @Override
    public void deleteTask(UUID taskId) {
        Task task=taskRepository.findById(taskId).orElseThrow(()-> new  TaskNotFoundException(taskId));
         taskRepository.delete(task);
    }


}
