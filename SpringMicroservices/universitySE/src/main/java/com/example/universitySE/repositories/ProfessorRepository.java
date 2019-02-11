package com.example.universitySE.repositories;

import com.example.universitySE.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findProfessorById(long id);

    List<Professor> findAllBySubject(int subject);

    Optional<Professor> findProfessorBySubject(int subject);
}
