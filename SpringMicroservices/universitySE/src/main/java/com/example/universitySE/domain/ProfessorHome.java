package com.example.universitySE.domain;
// Generated 28-gen-2019 15.27.51 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Professor.
 * @see Professor
 * @author Hibernate Tools
 */
@Stateless
public class ProfessorHome {

    private static final Log log = LogFactory.getLog(ProfessorHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Professor transientInstance) {
        log.debug("persisting Professor instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Professor persistentInstance) {
        log.debug("removing Professor instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Professor merge(Professor detachedInstance) {
        log.debug("merging Professor instance");
        try {
            Professor result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Professor findById( int id) {
        log.debug("getting Professor instance with id: " + id);
        try {
            Professor instance = entityManager.find(Professor.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

