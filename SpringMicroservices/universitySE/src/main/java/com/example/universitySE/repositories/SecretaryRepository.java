package com.example.universitySE.repositories;

import com.example.universitySE.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Integer> {

    Optional<Secretary> findSecretaryById(long id);

    void save(Person person);

    void save(Professor professor);

    void save(Student student);

    void save(StudyCourse studyCourse);

    void save(Subject subject);

    void save(Classroom classroom);

    void save(Activity activity);

    void save(Exam exam);

    void save(Lesson lesson);

    void save(Reporting reporting);
}
