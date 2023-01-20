package org.university.grades.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.grades.entity.Grade;
import org.university.grades.service.IGradeService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/grades")
@RequiredArgsConstructor
public class GradeController {
    private final IGradeService gradeService;

    @PostMapping
    public ResponseEntity<Grade> saveGrade(@RequestBody Grade grade) {
        return ResponseEntity.ok(this.gradeService.save(grade));
    }

    @GetMapping
    public ResponseEntity<List<Grade>> getAllGrades() {
        List<Grade> gradeList = this.gradeService.findAll();
        if (gradeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gradeList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Grade> getGradeById(@PathVariable Long id) {
        Optional<Grade> foundGrade = this.gradeService.findById(id);
        return foundGrade.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<List<Grade>> getAllByStudentId(@PathVariable Long id) {
        List<Grade> gradeList = this.gradeService.findAllByStudentId(id);
        if (gradeList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(gradeList);
    }

    @PutMapping("{id}")
    public ResponseEntity<Grade> updateGrade(@PathVariable Long id, @RequestBody Grade grade) {
        Optional<Grade> foundGrade = this.gradeService.findById(id);
        if (foundGrade.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        grade.setId(id);
        return ResponseEntity.ok(this.gradeService.update(grade));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Grade> deleteGrade(@PathVariable Long id) {
        Optional<Grade> foundGrade = this.gradeService.findById(id);
        if (foundGrade.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.gradeService.delete(id));
    }
}