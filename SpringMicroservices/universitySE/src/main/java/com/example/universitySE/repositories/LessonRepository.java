package com.example.universitySE.repositories;

import com.example.universitySE.domain.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Lesson (id) VALUES (?1)", nativeQuery = true)
    void addLesson(int id);

}
