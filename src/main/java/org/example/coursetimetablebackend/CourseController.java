package org.example.coursetimetablebackend;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
@CrossOrigin
public class CourseController {

    private final CourseRepository repository;

    public CourseController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Course> getCourses() {
        return repository.findAll();
    }

    @PostMapping
    public Course addCourse(@RequestBody Course course) {
        return repository.save(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(
            @PathVariable int id,
            @RequestBody Course course) {

        Course existingCourse = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        existingCourse.setCourseName(course.getCourseName());
        existingCourse.setFacultyId(course.getFacultyId());

        return repository.save(existingCourse);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable int id) {
        repository.deleteById(id);
    }
}