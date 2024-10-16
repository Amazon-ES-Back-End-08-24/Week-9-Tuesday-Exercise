package com.ironhack.week9tuesdayexercise.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseResponseDTO {
    private Long id;

    private String courseName;

    private String instructorName;

    private LocalDate startDate;

    private Integer durationInWeeks;
}
