package com.ironhack.week9tuesdayexercise.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;

    private String instructorName;

    private LocalDate startDate;

    private Integer durationInWeeks;

    public Course(String courseName, String instructorName, LocalDate startDate, Integer durationInWeeks) {
        this.courseName = courseName;
        this.instructorName = instructorName;
        this.startDate = startDate;
        this.durationInWeeks = durationInWeeks;
    }
}
