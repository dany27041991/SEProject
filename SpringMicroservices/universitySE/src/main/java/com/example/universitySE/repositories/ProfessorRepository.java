package com.example.universitySE.repositories;

import com.example.universitySE.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

    Optional<Professor> findProfessorById(int id);

    List<Professor> findAllBySubject(int subject);

    Optional<Professor> findProfessorBySubject(int subject);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Professor (id, first_name, last_name, biography, reception_time, subject, date_of_birth) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void addProfessor(int id, String first_name, String last_name, String biography, String reception_time, int subject, Date date_of_birth);
}
