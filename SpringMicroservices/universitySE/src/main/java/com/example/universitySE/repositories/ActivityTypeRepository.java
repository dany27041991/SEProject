package com.example.universitySE.repositories;

import com.example.universitySE.domain.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ActivityTypeRepository extends JpaRepository<ActivityType, Integer> {

    Optional<ActivityType> findActivityTypeById(long id);

    List<ActivityType> findAll();
}
