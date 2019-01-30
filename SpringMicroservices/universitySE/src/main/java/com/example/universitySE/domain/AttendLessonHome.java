package com.example.universitySE.domain;
// Generated 29-gen-2019 18.51.34 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class AttendLesson.
 * @see AttendLesson
 * @author Hibernate Tools
 */
@Stateless
public class AttendLessonHome {

    private static final Log log = LogFactory.getLog(AttendLessonHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(AttendLesson transientInstance) {
        log.debug("persisting AttendLesson instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(AttendLesson persistentInstance) {
        log.debug("removing AttendLesson instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public AttendLesson merge(AttendLesson detachedInstance) {
        log.debug("merging AttendLesson instance");
        try {
            AttendLesson result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public AttendLesson findById( int id) {
        log.debug("getting AttendLesson instance with id: " + id);
        try {
            AttendLesson instance = entityManager.find(AttendLesson.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

