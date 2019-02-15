package com.example.universitySE.repositories;

import com.example.universitySE.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Optional<Activity> findActivityById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Activity (study_course, subject, id_prof, start, end, activity_type) VALUES (?1, ?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void addActivity(int study_course, int subject, int id_prof, Date start, Date end, int activity_type);

    List<Activity> findAll();


}
