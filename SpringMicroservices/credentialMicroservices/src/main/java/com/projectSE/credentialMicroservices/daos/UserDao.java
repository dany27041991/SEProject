package com.projectSE.credentialMicroservices.daos;

import com.projectSE.credentialMicroservices.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Integer> {

}
