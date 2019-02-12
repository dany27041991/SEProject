package com.example.universitySE.repositories;

import com.example.universitySE.domain.StudyCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudyCourseRepository extends JpaRepository<StudyCourse, Integer> {

    List<StudyCourse> findAllByFaculty(long faculty);

    Optional<StudyCourse> findStudyCourseById(long id);
}
