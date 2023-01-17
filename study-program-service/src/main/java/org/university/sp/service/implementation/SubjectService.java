package org.university.sp.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.university.sp.entity.Subject;
import org.university.sp.repository.ISubjectRepository;
import org.university.sp.service.ISubjectService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SubjectService implements ISubjectService {
    private final ISubjectRepository subjectRepository;

    @Override
    @Transactional
    public Subject save(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Subject> findAll() {
        return this.subjectRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Subject> findById(Long id) {
        return this.subjectRepository.findById(id);
    }

    @Override
    @Transactional
    public Subject update(Subject subject) {
        return this.subjectRepository.save(subject);
    }

    @Override
    @Transactional
    public Subject delete(Long id) {
        Optional<Subject> foundSubject = this.subjectRepository.findById(id);
        if (foundSubject.isPresent()) {
            this.subjectRepository.deleteById(id);
            return foundSubject.get();
        }
        return null;
    }
}