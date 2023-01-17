package org.university.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.university.sp.entity.Course;

@Repository
public interface ICourseRepository extends JpaRepository<Course, Long> {}