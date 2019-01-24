package com.example.universitySE.repositories;

import com.example.universitySE.domain.Student;
import com.example.universitySE.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Optional<Student> findStudentById(int id);

}
