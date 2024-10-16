package com.ironhack.week9tuesdayexercise.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRequestDTO {

    @NotBlank(message = "Course name is required")
    @Size(min = 3, max = 100, message = "Course name must be between 3 and 100 characters")
    private String courseName;

    @NotBlank(message = "Instructor name is required")
    @Size(min = 3, max = 50, message = "Instructor name must be between 3 and 50 characters")
    private String instructorName;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date must be in the present or future")
    private LocalDate startDate;

    @Min(value = 1, message = "Duration must be at least 1 week")
    private Integer durationInWeeks;
}
