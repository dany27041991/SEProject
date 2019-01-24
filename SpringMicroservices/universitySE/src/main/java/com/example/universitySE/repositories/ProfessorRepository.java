package com.example.universitySE.repositories;

import com.example.universitySE.domain.Professor;
import com.example.universitySE.models.ProfessorModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findProfessorById(int id);
}
