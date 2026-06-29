package com.omar.tasks.domain;

import com.omar.tasks.domain.entity.TaskPriority;

import java.time.LocalDate;

public record CreatetaskRequest(
        String title,
        String description,
        LocalDate dueDate,
        TaskPriority priority) {



}
