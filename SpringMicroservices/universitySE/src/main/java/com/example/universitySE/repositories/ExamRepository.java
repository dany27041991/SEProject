package com.example.universitySE.repositories;

import com.example.universitySE.domain.Exam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Exam (id) VALUES (?1)", nativeQuery = true)
    void addExam(int id);
}
