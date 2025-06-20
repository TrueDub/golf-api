package com.castlemon.golf.controller;

import com.castlemon.golf.entity.Course;
import com.castlemon.golf.exception.CourseNotFoundException;
import com.castlemon.golf.repository.CourseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
class CourseController {

    private final CourseRepository repository;

    CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin()
    @GetMapping("/courses")
    List<Course> all() {
        return repository.findAll();
    }

    @CrossOrigin()
    @PostMapping("/courses")
    Course newCourse(@RequestBody Course newCourse) {
        return repository.save(newCourse);
    }

    // Single item

    @GetMapping("/courses/{id}")
    Course one(@PathVariable Integer id) {

        return repository.findById(id)
                .orElseThrow(() -> new CourseNotFoundException(id));
    }

    @PutMapping("/courses/{id}")
    Course replaceCourse(@RequestBody Course newCourse, @PathVariable Integer id) {

        return repository.findById(id)
                .map(Course -> {
                    Course.setCourseName(newCourse.getCourseName());
                    Course.setTees(newCourse.getTees());
                    return repository.save(Course);
                })
                .orElseGet(() -> {
                    return repository.save(newCourse);
                });
    }

    @DeleteMapping("/courses/{id}")
    void deleteCourse(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
