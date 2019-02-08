package com.example.universitySE.repositories;

import com.example.universitySE.domain.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StateRepository extends JpaRepository<State, Integer> {

    Optional<State> findStateById(long id);

    List<State> findAll();
}
