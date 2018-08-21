package com.projectSE.credentialMicroservices.daos;

import com.projectSE.credentialMicroservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserDao extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

    List<User> findByNameAndSurname(String name, String surname);

}