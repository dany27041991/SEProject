package com.example.universitySE.repositories;

import com.example.universitySE.domain.Secretary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SecretaryRepository extends JpaRepository<Secretary, Integer> {

    Optional<Secretary> findSecretaryById(int id);
}
