package com.example.universitySE.repositories;

import com.example.universitySE.domain.Subject;
import org.hibernate.jpa.event.spi.jpa.ListenerFactoryBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {

    Optional<Subject> findSubjectById(int id);

    List<Subject> findAllByStudyCourse(int study_course);

    List<Subject> findAll();

    List<Subject> findSubjectByStudyCourse(int study_course);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Subject (name, study_course, year_course) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addSubject(String name, int study_course, int year_course);

}
