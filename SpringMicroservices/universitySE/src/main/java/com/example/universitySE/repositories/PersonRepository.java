package com.example.universitySE.repositories;

import com.example.universitySE.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    Optional<Person> findPersonByUsernameAndPassword(String username, String password);

    Optional<Person> findPersonByUsernameAndPasswordAndPersonType(String username, String password, int person_type);

    List<Person> findAllByPersonType(int type);

}
