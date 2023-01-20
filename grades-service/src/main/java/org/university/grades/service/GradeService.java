package org.university.grades.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.university.grades.entity.Grade;
import org.university.grades.repository.IGradeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class GradeService implements IGradeService {
    private final IGradeRepository gradeRepository;

    @Override
    @Transactional
    public Grade save(Grade grade) {
        return this.gradeRepository.save(grade);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Grade> findAll() {
        return this.gradeRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Grade> findById(Long id) {
        return this.gradeRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Grade> findAllByStudentId(Long StudentId) {
        return this.gradeRepository.findByStudentId(StudentId);
    }

    @Override
    @Transactional
    public Grade update(Grade grade) {
        return this.gradeRepository.save(grade);
    }

    @Override
    @Transactional
    public Grade delete(Long id) {
        Optional<Grade> foundGrade = this.gradeRepository.findById(id);
        if (foundGrade.isPresent()) {
            this.gradeRepository.deleteById(id);
            return foundGrade.get();
        }
        return null;
    }
}