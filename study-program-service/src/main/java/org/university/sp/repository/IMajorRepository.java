package org.university.sp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.university.sp.entity.Major;

@Repository
public interface IMajorRepository extends JpaRepository<Major, Long> {}