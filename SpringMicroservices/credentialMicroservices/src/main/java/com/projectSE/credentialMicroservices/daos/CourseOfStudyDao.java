package com.projectSE.credentialMicroservices.daos;

import com.projectSE.credentialMicroservices.entities.CourseOfStudy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseOfStudyDao extends JpaRepository<CourseOfStudy, Integer> {
}
