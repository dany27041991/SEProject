package com.example.universitySE.domain;
// Generated 31-gen-2019 19.40.01 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Exam.
 * @see Exam
 * @author Hibernate Tools
 */
@Stateless
public class ExamHome {

    private static final Log log = LogFactory.getLog(ExamHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Exam transientInstance) {
        log.debug("persisting Exam instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Exam persistentInstance) {
        log.debug("removing Exam instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Exam merge(Exam detachedInstance) {
        log.debug("merging Exam instance");
        try {
            Exam result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Exam findById( int id) {
        log.debug("getting Exam instance with id: " + id);
        try {
            Exam instance = entityManager.find(Exam.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

