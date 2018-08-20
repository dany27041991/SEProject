package com.projectSE.credentialMicroservices.daos;

import com.projectSE.credentialMicroservices.entities.UserType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTypeDao extends JpaRepository<UserType, Integer> {
}
