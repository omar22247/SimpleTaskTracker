package com.omar.tasks.mapper;

import com.omar.tasks.domain.CreatetaskRequest;
import com.omar.tasks.domain.entity.Task;
import com.omar.tasks.domain.entity.UpdateTaskRequest;
import com.omar.tasks.dto.CreatetaskRequestDto;
import com.omar.tasks.dto.TaskDto;
import com.omar.tasks.dto.UpdateTaskRequestDto;

import java.util.List;

public interface TaskMapper {
    CreatetaskRequest fromDto(CreatetaskRequestDto dto);
    TaskDto toDto(Task task);
    UpdateTaskRequest fromDto(UpdateTaskRequestDto dto);
}
