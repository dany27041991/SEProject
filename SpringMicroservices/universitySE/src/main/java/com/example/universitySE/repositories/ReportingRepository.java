package com.example.universitySE.repositories;

import com.example.universitySE.domain.Reporting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ReportingRepository extends JpaRepository<Reporting, Integer> {

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Reporting (note_prof, support_material_prof, state, id_prof, id_classroom) VALUES (?1, ?2, ?3, ?4, ?5)", nativeQuery = true)
    void addReporting(String note_prof, int support_material_prof, int state, int id_prof, int id_classroom);

    List<Reporting> findAll();

    Optional<Reporting> getReportingById(int id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Reporting SET note_sec = ?2, state = ?3, id_secretary = ?4 WHERE id = ?1", nativeQuery = true)
    void updateReporting(int id, String note_sec, int state, int id_secretary);

    List<Reporting> findReportingsByIdProf(int professor);

}
