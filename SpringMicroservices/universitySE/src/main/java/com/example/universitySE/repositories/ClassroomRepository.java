package com.example.universitySE.repositories;

import com.example.universitySE.domain.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {

    List<Classroom> findAll();

    Optional<Classroom> findClassroomById(int id);

}
