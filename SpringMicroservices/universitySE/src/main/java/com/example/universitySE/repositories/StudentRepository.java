package com.example.universitySE.repositories;

import com.example.universitySE.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Student (id, first_name, last_name, date_of_birth, badge_number, study_course, enrollment_year) VALUES (?1, ?2, ?3, ?4, ?5, ?6, ?7)", nativeQuery = true)
    void addStudent(int id, String first_name, String last_name, Date date_of_birth, int badge_number, int study_course, Date enrollment_year);

}
