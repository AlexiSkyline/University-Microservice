package org.university.sp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.sp.entity.Course;
import org.university.sp.service.ICourseService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/study-program/courses")
@RequiredArgsConstructor
public class CourseController {
    private final ICourseService courseService;

    @PostMapping
    public ResponseEntity<Course> saveCourse(@RequestBody Course course) {
        return ResponseEntity.ok(this.courseService.save(course));
    }

    @GetMapping
    public ResponseEntity<List<Course>> findAllCourses() {
        List<Course> courseList = this.courseService.findAll();
        if (courseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courseList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Course> findCourseById(@PathVariable Long id) {
        Optional<Course> foundCourse = this.courseService.findById(id);
        return foundCourse.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("professor/{professorId}")
    public ResponseEntity<List<Course>> findAllCoursesByProfessorId(@PathVariable Long professorId) {
        List<Course> courseList = this.courseService.findAllCoursesByProfessorId(professorId);
        if (courseList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(courseList);
    }

    @PutMapping("{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        Optional<Course> foundCourse = this.courseService.findById(id);
        if (foundCourse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        course.setId(id);
        return ResponseEntity.ok(this.courseService.update(course));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id) {
        Optional<Course> foundCourse = this.courseService.findById(id);
        if (foundCourse.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.courseService.delete(id));
    }
}