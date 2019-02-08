package com.example.universitySE.repositories;

import com.example.universitySE.domain.DownloadTeachingMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface DownloadTeachingMaterialRepository extends JpaRepository<DownloadTeachingMaterial, Integer>{

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO Download_teaching_material (feedback_student, badge_student, id_teaching_material, note) VALUES (?1, ?2, ?3, ?4)", nativeQuery = true)
    void addReporting(int feedbak, int badge, int id_material, String note);

}
