package org.university.sp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.sp.entity.Subject;
import org.university.sp.service.ISubjectService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/study-program/subjects")
@RequiredArgsConstructor
public class SubjectController {
    private final ISubjectService subjectService;

    @PostMapping
    public ResponseEntity<Subject> saveSubject(@RequestBody Subject subject) {
        return ResponseEntity.ok(this.subjectService.save(subject));
    }

    @GetMapping
    public ResponseEntity<List<Subject>> findAllSubjects() {
        List<Subject> subjectList = this.subjectService.findAll();
        if (subjectList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subjectList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Subject> findSubjectById(@PathVariable Long id) {
        Optional<Subject> foundSubject = this.subjectService.findById(id);
        return foundSubject.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("course/{id}")
    public ResponseEntity<List<Subject>> findAllSubjectsByCourseId(@PathVariable Long id) {
        List<Subject> subjectList = this.subjectService.findAllSubjectsByCourseId(id);
        if (subjectList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subjectList);
    }

    @GetMapping("professor/{professorId}")
    public ResponseEntity<List<Subject>> findAllSubjectsByProfessorId(@PathVariable Long professorId) {
        List<Subject> subjectList = this.subjectService.findAllByProfessorId(professorId);
        if (subjectList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(subjectList);
    }

    @PutMapping("{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        Optional<Subject> foundSubject = this.subjectService.findById(id);
        if (foundSubject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        subject.setId(id);
        return ResponseEntity.ok(this.subjectService.update(subject));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Subject> deleteSubject(@PathVariable Long id) {
        Optional<Subject> foundSubject = this.subjectService.findById(id);
        if (foundSubject.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.subjectService.delete(id));
    }
}