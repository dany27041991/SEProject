package com.example.universitySE.repositories;

import com.example.universitySE.domain.AttendLesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AttendLessonRepository extends JpaRepository<AttendLesson, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Attend_lesson (feedback, id_lesson, badge_student) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addExam(int feedback, int id_lesson, int badge_student);

    List<AttendLesson> findAll();

}
