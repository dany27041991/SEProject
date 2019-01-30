package com.example.universitySE.domain;
// Generated 29-gen-2019 18.51.34 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class BookExam.
 * @see BookExam
 * @author Hibernate Tools
 */
@Stateless
public class BookExamHome {

    private static final Log log = LogFactory.getLog(BookExamHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(BookExam transientInstance) {
        log.debug("persisting BookExam instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(BookExam persistentInstance) {
        log.debug("removing BookExam instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public BookExam merge(BookExam detachedInstance) {
        log.debug("merging BookExam instance");
        try {
            BookExam result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public BookExam findById( int id) {
        log.debug("getting BookExam instance with id: " + id);
        try {
            BookExam instance = entityManager.find(BookExam.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

