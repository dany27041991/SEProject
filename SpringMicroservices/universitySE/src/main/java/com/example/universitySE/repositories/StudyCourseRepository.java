package com.example.universitySE.repositories;

import com.example.universitySE.domain.StudyCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface StudyCourseRepository extends JpaRepository<StudyCourse, Integer> {

    List<StudyCourse> findAllByFaculty(int faculty);

    Optional<StudyCourse> findStudyCourseById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Study_course (name, faculty) VALUES (?1, ?2)", nativeQuery = true)
    void addStudyCourse(String name, int faculty);

}
