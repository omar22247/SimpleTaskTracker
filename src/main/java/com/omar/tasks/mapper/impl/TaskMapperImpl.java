package com.omar.tasks.mapper.impl;

import com.omar.tasks.domain.CreatetaskRequest;
import com.omar.tasks.domain.entity.Task;
import com.omar.tasks.domain.entity.UpdateTaskRequest;
import com.omar.tasks.dto.CreatetaskRequestDto;
import com.omar.tasks.dto.TaskDto;
import com.omar.tasks.dto.UpdateTaskRequestDto;
import com.omar.tasks.mapper.TaskMapper;
import org.springframework.stereotype.Component;

@Component
public class TaskMapperImpl implements TaskMapper {

    @Override
    public CreatetaskRequest fromDto(CreatetaskRequestDto dto) {

        return new CreatetaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.priority());
    }

    @Override
    public TaskDto toDto(Task task) {
        return new TaskDto(task.getId(), task.getTitle(), task.getDescription(), task.getDueDate(), task.getPriority());
    }

    @Override
    public UpdateTaskRequest fromDto(UpdateTaskRequestDto dto) {
        return new UpdateTaskRequest(dto.title(), dto.description(), dto.dueDate(), dto.status(), dto.priority());
    }
}
