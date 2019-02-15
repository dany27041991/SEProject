package com.example.universitySE.repositories;

import com.example.universitySE.domain.CarryoutActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface CarryoutActivityRepository extends JpaRepository<CarryoutActivity, Integer> {

    List<CarryoutActivity> findAll();

    Optional<CarryoutActivity> findCarryoutActivityById(int id);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Carryout_activity (id_activity, classroom_name) VALUES (?1, ?2)", nativeQuery = true)
    void addCarryoutActivity(int id_activity, int classroom_name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Carryout_activity SET classroom_name = ?2 WHERE id = ?1", nativeQuery = true)
    void updateCarryoutActivity(int id, int classroom_name);

}
