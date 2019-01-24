package com.example.universitySE.domain;
// Generated 24-gen-2019 10.24.30 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class State.
 * @see State
 * @author Hibernate Tools
 */
@Stateless
public class StateHome {

    private static final Log log = LogFactory.getLog(StateHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(State transientInstance) {
        log.debug("persisting State instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(State persistentInstance) {
        log.debug("removing State instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public State merge(State detachedInstance) {
        log.debug("merging State instance");
        try {
            State result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public State findById( int id) {
        log.debug("getting State instance with id: " + id);
        try {
            State instance = entityManager.find(State.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

