package com.ironhack.week9tuesdayexercise.repository;

import com.ironhack.week9tuesdayexercise.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
}
