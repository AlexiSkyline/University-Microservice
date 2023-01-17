package org.university.sp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.university.sp.entity.Major;
import org.university.sp.service.IMajorService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/study-program/majors")
@RequiredArgsConstructor
public class MajorController {
    private final IMajorService majorService;

    @PostMapping
    public ResponseEntity<Major> saveMajor(@RequestBody Major major) {
        return ResponseEntity.ok(this.majorService.save(major));
    }

    @GetMapping
    public ResponseEntity<List<Major>> findAllMajors() {
        List<Major> majorList = this.majorService.findAll();
        if (majorList.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(majorList);
    }

    @GetMapping("{id}")
    public ResponseEntity<Major> findMajorById(@PathVariable Long id) {
        Optional<Major> foundMajor = this.majorService.findById(id);
        return foundMajor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("{id}")
    public ResponseEntity<Major> updateMajor(@PathVariable Long id, @RequestBody Major major) {
        Optional<Major> foundMajor = this.majorService.findById(id);
        if (foundMajor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        major.setId(id);
        return ResponseEntity.ok(this.majorService.update(major));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Major> deleteMajor(@PathVariable Long id) {
        Optional<Major> foundMajor = this.majorService.findById(id);
        if (foundMajor.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.majorService.delete(id));
    }
}