package com.example.universitySE.repositories;

import com.example.universitySE.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findAll();

    Optional<Classroom> findClassroomById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Classroom (name, latitude, longitude) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addClassroom(String name, BigDecimal latitude, BigDecimal longitude);

}