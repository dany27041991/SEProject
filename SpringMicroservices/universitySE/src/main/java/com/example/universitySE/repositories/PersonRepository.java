package com.example.universitySE.repositories;

import com.example.universitySE.domain.Person;
import com.example.universitySE.models.PersonModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    @Query(value = "SELECT * FROM Person LEFT JOIN Student ON Person.id=Student.id LEFT JOIN Professor ON Person.id=Professor.id where Person.password=?1 and Person.username=?2", nativeQuery = true)
    Optional<PersonModel> findPersonByUsernameAndAndPassword(String username, String password);
}