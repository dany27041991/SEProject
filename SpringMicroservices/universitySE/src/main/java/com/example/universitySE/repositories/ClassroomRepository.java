package com.example.universitySE.repositories;

import com.example.universitySE.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findAll();

    Optional<Classroom> findClassroomById(int id);
}