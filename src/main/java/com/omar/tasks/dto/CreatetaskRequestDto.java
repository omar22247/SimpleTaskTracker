package com.omar.tasks.dto;

import com.omar.tasks.domain.entity.TaskPriority;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public record CreatetaskRequestDto(
        @NotBlank(message =ERROR_MESSAGE_TITLE_LENGTH)
        @Length( max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        String title,

        @Length( max = 255, message = ERROR_MESSAGE_TITLE_LENGTH)
        @Nullable
        String description,

        @Nullable
        @FutureOrPresent(message =ERROR_MESSAGE_DUEDATE_LENGTH )
        LocalDate dueDate,

        @NotNull(message = ERROR_MESSAGE_PRIORITY_LENGTH)
        TaskPriority priority
) {
    private static final String ERROR_MESSAGE_TITLE_LENGTH =
            "Title must be between 1 and 255 characters .";
    private static final String ERROR_MESSAGE_DESCRIPTION_LENGTH =
            "Description must be less 1000 characters .";
    private static final String ERROR_MESSAGE_DUEDATE_LENGTH =
            "Due date must be in the present or future.";
    private static final String ERROR_MESSAGE_PRIORITY_LENGTH =
            "Priority must be specified.";
}
