package com.example.universitySE.repositories;

import com.example.universitySE.domain.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonTypeRepository extends JpaRepository<PersonType, Integer> {

    Optional<PersonType> findPersonTypeById(long id);

    List<PersonType> findAll();
}
