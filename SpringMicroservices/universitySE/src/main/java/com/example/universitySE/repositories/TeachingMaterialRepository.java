package com.example.universitySE.repositories;

import com.example.universitySE.domain.TeachingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface TeachingMaterialRepository extends JpaRepository<TeachingMaterial, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Teaching_material (subject, media) VALUES (?1, ?2)", nativeQuery = true)
    void addTeachingMaterial(int subject, String media);

    List<TeachingMaterial> getTeachingMaterialBySubject(long subject);

}
