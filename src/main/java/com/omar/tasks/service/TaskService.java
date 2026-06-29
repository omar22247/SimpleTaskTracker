package com.omar.tasks.service;

import com.omar.tasks.domain.CreatetaskRequest;
import com.omar.tasks.domain.entity.Task;
import com.omar.tasks.domain.entity.UpdateTaskRequest;

import java.util.List;
import java.util.UUID;

public interface TaskService {

    Task createTask(CreatetaskRequest request);
    List<Task> findAllTasks();
    Task updateTask(UUID TaskId, UpdateTaskRequest request);
    void deleteTask(UUID TaskId);
}
