package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.15 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Secretary.
 * @see Secretary
 * @author Hibernate Tools
 */
@Stateless
public class SecretaryHome {

    private static final Log log = LogFactory.getLog(SecretaryHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Secretary transientInstance) {
        log.debug("persisting Secretary instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Secretary persistentInstance) {
        log.debug("removing Secretary instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Secretary merge(Secretary detachedInstance) {
        log.debug("merging Secretary instance");
        try {
            Secretary result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Secretary findById( int id) {
        log.debug("getting Secretary instance with id: " + id);
        try {
            Secretary instance = entityManager.find(Secretary.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

