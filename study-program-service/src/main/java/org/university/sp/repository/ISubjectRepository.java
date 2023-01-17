package org.university.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.university.sp.entity.Subject;

@Repository
public interface ISubjectRepository extends JpaRepository<Subject, Long> {}