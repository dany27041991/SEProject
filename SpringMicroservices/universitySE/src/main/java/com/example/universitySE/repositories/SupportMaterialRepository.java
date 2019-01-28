package com.example.universitySE.repositories;

import com.example.universitySE.domain.SupportMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupportMaterialRepository extends JpaRepository<SupportMaterial, Integer>{

    List<SupportMaterial> findAll();

}
