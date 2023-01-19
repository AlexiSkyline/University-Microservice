package org.university.student.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.university.student.entity.Student;
import org.university.student.repository.IStudentRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService implements IStudentService {
    private final IStudentRepository studentRepository;

    @Override
    @Transactional
    public Student save(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {
        return this.studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findById(Long id) {
        return this.studentRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Student> findByRegistration(String registration) {
        return this.studentRepository.findStudentByRegistration(registration);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findByMajorId(Long id) {
        return this.studentRepository.findByMajorId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> findByCourseId(Long id) {
        return this.studentRepository.findByCourseId(id);
    }

    @Override
    public Student update(Student student) {
        return this.studentRepository.save(student);
    }

    @Override
    @Transactional
    public Student delete(Long id) {
        Optional<Student> foundStudent = this.studentRepository.findById(id);
        if (foundStudent.isPresent()) {
            this.studentRepository.deleteById(id);
            return foundStudent.get();
        }
        return null;
    }
}