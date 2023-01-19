package org.university.professor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.professor.dto.CourseDTO;
import org.university.professor.dto.MajorDTO;
import org.university.professor.dto.SubjectDTO;
import org.university.professor.entity.Professor;
import org.university.professor.feignclients.StudyProgramService;
import org.university.professor.service.IProfessorService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final IProfessorService professorService;
    private final StudyProgramService studyProgramService;

    @PostMapping
    public ResponseEntity<Professor> saveProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(this.professorService.save(professor));
    }

    @GetMapping
    public ResponseEntity<List<Professor>> getAllProfessors() {
        List<Professor> professorList = this.professorService.findAll();
        if (professorList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(professorList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        Optional<Professor> foundProfessor = this.professorService.findById(id);
        return foundProfessor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professor) {
        Optional<Professor> foundProfessor = this.professorService.findById(id);
        if (foundProfessor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        professor.setId(id);
        return ResponseEntity.ok(this.professorService.update(professor));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Professor> deleteProfessor(@PathVariable Long id) {
        Optional<Professor> foundProfessor = this.professorService.findById(id);
        if (foundProfessor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.professorService.delete(id));
    }

    @GetMapping("major/{id}")
    public ResponseEntity<Map<String, Object>> getProfessorsByMajorId(@PathVariable Long id) {
        List<Professor> professorList = this.professorService.findAllByMajorId(id);
        if (professorList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        MajorDTO majorDTO = this.studyProgramService.getMajorById(id);
        Map<String, Object> response = new HashMap<>();
        response.put("majorInfo", majorDTO);
        response.put("professorList", professorList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}/subjects")
    public ResponseEntity<Map<String, Object>> getAllSubjectByProfessorId(@PathVariable Long id) {
        Optional<Professor> foundProfessor = this.professorService.findById(id);
        if (foundProfessor.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<SubjectDTO> subjectList = this.studyProgramService.getSubjectsByProfessorId(id);
        Map<String, Object> response = new HashMap<>();
        response.put("professorInfo", foundProfessor);
        response.put("subjectList", subjectList);
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}/courses")
    public ResponseEntity<Map<String, Object>> getAllCoursesByProfessorId(@PathVariable Long id) {
        Optional<Professor> foundProfessor = this.professorService.findById(id);
        if (foundProfessor.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        List<CourseDTO> courseList = this.studyProgramService.getAllCoursesByProfessorId(id);
        Map<String, Object> response = new HashMap<>();
        response.put("professorInfo", foundProfessor);
        response.put("courseList", courseList);
        return ResponseEntity.ok(response);
    }
}