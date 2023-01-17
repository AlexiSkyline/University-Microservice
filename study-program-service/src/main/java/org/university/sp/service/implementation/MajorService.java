package org.university.sp.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.university.sp.entity.Major;
import org.university.sp.repository.IMajorRepository;
import org.university.sp.service.IMajorService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MajorService implements IMajorService {
    private final IMajorRepository majorRepository;

    @Override
    @Transactional
    public Major save(Major major) {
        return this.majorRepository.save(major);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Major> findAll() {
        return this.majorRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Major> findById(Long id) {
        return this.majorRepository.findById(id);
    }

    @Override
    @Transactional
    public Major update(Major major) {
        return this.majorRepository.save(major);
    }

    @Override
    @Transactional
    public Major delete(Long id) {
        Optional<Major> foundMajor = this.majorRepository.findById(id);
        if (foundMajor.isPresent()) {
            this.majorRepository.deleteById(id);
            return foundMajor.get();
        }
        return null;
    }
}