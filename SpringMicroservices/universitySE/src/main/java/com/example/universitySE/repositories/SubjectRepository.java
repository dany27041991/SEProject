package com.example.universitySE.repositories;

import com.example.universitySE.domain.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Optional<Subject> findSubjectById(int id);

}
