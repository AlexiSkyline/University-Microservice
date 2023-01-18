package org.university.sp.service.implementation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.university.sp.entity.Course;
import org.university.sp.repository.ICourseRepository;
import org.university.sp.service.ICourseService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {
    private final ICourseRepository courseRepository;

    @Override
    @Transactional
    public Course save(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {
        return this.courseRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Course> findById(Long id) {
        return this.courseRepository.findById(id);
    }

    @Override
    @Transactional
    public Course update(Course course) {
        return this.courseRepository.save(course);
    }

    @Override
    @Transactional
    public Course delete(Long id) {
        Optional<Course> foundCourse = this.courseRepository.findById(id);
        if (foundCourse.isPresent()) {
            this.courseRepository.deleteById(id);
            return foundCourse.get();
        }
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAllByProfessorId(Long professorId) {
        List<Course> courseList = this.courseRepository.findAllByProfessorId(professorId);
        courseList.forEach(course -> {
            course.setSubjects(course.getSubjects().stream()
                    .filter(subject -> subject.getProfessorId().equals(professorId)).toList());
        });
        return courseList;
    }
}