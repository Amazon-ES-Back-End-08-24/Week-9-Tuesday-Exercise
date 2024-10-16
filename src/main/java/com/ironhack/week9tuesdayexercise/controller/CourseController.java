package com.ironhack.week9tuesdayexercise.controller;

import com.ironhack.week9tuesdayexercise.dto.CourseRequestDTO;
import com.ironhack.week9tuesdayexercise.dto.CourseResponseDTO;
import com.ironhack.week9tuesdayexercise.model.Course;
import com.ironhack.week9tuesdayexercise.repository.CourseRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

//    @PostMapping
//    @ResponseStatus(HttpStatus.CREATED)
//    public Course createCourse (@RequestBody Course course){
//        Course courseFromDB = courseRepository.save(course);
//        return courseFromDB;
//    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course courseFromDB = courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(courseFromDB);
    }


//    @PostMapping("/create-void")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createCourseReturnVoid (@RequestBody Course course){
//        courseRepository.save(course);
//    }


    @PostMapping("/create-void")
    public ResponseEntity<Void> createCourseReturnVoid(@RequestBody Course course) {
        courseRepository.save(course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @PostMapping("/create-dto")
    public ResponseEntity<CourseResponseDTO> createCourseWithDTO(@Valid @RequestBody CourseRequestDTO requestDTO) {
        Course course = new Course(requestDTO.getCourseName(), requestDTO.getInstructorName(), requestDTO.getStartDate(),
                requestDTO.getDurationInWeeks());

        Course courseFromDB = courseRepository.save(course);

        CourseResponseDTO responseDTO = new CourseResponseDTO(courseFromDB.getId(), courseFromDB.getCourseName()
                , courseFromDB.getInstructorName(), courseFromDB.getStartDate(), courseFromDB.getDurationInWeeks());

        return ResponseEntity.status(HttpStatus.CREATED).body(responseDTO);
    }
}
