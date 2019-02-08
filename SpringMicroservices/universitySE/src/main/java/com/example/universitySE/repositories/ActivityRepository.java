package com.example.universitySE.repositories;

import com.example.universitySE.domain.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface ActivityRepository extends JpaRepository<Activity, Integer> {

    Optional<Activity> findActivityById(long id);
}
