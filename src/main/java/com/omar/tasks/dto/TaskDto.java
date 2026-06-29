package com.omar.tasks.dto;

import com.omar.tasks.domain.entity.TaskPriority;

import java.time.LocalDate;
import java.util.UUID;

public record TaskDto(
        UUID id,
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority
) {
}
