package com.example.universitySE.repositories;

import com.example.universitySE.domain.CarryoutActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarryoutActivityRepository extends JpaRepository<CarryoutActivity, Integer> {

    List<CarryoutActivity> findAll();

    Optional<CarryoutActivity> findCarryoutActivityById(long id);
}
