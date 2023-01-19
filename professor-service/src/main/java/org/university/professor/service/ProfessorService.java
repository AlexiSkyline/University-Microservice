package org.university.professor.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.university.professor.entity.Professor;
import org.university.professor.repository.IProfessorRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfessorService implements IProfessorService {
    private final IProfessorRepository professorRepository;

    @Override
    @Transactional
    public Professor save(Professor professor) {
        return this.professorRepository.save(professor);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> findAll() {
        return this.professorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Professor> findById(Long id) {
        return this.professorRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Professor> findAllByMajorId(Long majorId) {
        return this.professorRepository.findAllByMajorId(majorId);
    }

    @Override
    @Transactional
    public Professor update(Professor professor) {
        return this.professorRepository.save(professor);
    }

    @Override
    @Transactional
    public Professor delete(Long id) {
        Optional<Professor> foundProfessor = this.professorRepository.findById(id);
        if (foundProfessor.isPresent()) {
            this.professorRepository.deleteById(id);
            return foundProfessor.get();
        }
        return null;
    }
}
