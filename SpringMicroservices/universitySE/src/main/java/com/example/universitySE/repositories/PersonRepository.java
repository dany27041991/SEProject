package com.example.universitySE.repositories;

import com.example.universitySE.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findPersonByUsernameAndPassword(String username, String password);

    Optional<Person> findPersonById(int id);

    List<Person> findAllByPersonType(int type);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Person (username, password, person_type) VALUES (?1, ?2, ?3)", nativeQuery = true)
    void addPerson(String username, String password, int person_type);

}
