package com.omar.tasks.controller;

import com.omar.tasks.domain.CreatetaskRequest;
import com.omar.tasks.domain.entity.Task;
import com.omar.tasks.dto.CreatetaskRequestDto;
import com.omar.tasks.dto.TaskDto;
import com.omar.tasks.dto.UpdateTaskRequestDto;
import com.omar.tasks.mapper.TaskMapper;
import com.omar.tasks.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;

    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @PostMapping
    public ResponseEntity<TaskDto> createTask(@Valid   @RequestBody CreatetaskRequestDto createtaskRequestDto) {
        CreatetaskRequest createtaskRequest = taskMapper.fromDto(createtaskRequestDto);
        TaskDto taskDto = taskMapper.toDto(taskService.createTask(createtaskRequest));
        return new ResponseEntity<>(taskDto, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TaskDto>> findAllTasks() {
        List<Task> tasks = taskService.findAllTasks();
        List<TaskDto> taskDtos = tasks.stream().map(taskMapper::toDto).toList();
        return  ResponseEntity.ok(taskDtos);
    }
    @PutMapping(path = "/{taskId}")
public ResponseEntity<TaskDto> updateTask(@PathVariable UUID taskId, @Valid  @RequestBody UpdateTaskRequestDto taskDto) {

        Task task = taskService.updateTask(taskId, taskMapper.fromDto(taskDto));
        TaskDto updatedTaskDto = taskMapper.toDto(task);
        return ResponseEntity.ok(updatedTaskDto);
    }
    @DeleteMapping(path="/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable UUID taskId) {
        taskService.deleteTask(taskId);
        System.out.println("delete task");
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}

