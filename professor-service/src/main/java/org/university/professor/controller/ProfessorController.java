package org.university.professor.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.professor.entity.Professor;
import org.university.professor.service.IProfessorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/professors")
@RequiredArgsConstructor
public class ProfessorController {
    private final IProfessorService professorService;

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
}