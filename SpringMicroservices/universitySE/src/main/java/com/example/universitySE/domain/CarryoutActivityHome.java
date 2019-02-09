package com.example.universitySE.domain;
// Generated 8-feb-2019 18.41.44 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class CarryoutActivity.
 * @see CarryoutActivity
 * @author Hibernate Tools
 */
@Stateless
public class CarryoutActivityHome {

    private static final Log log = LogFactory.getLog(CarryoutActivityHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(CarryoutActivity transientInstance) {
        log.debug("persisting CarryoutActivity instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(CarryoutActivity persistentInstance) {
        log.debug("removing CarryoutActivity instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public CarryoutActivity merge(CarryoutActivity detachedInstance) {
        log.debug("merging CarryoutActivity instance");
        try {
            CarryoutActivity result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public CarryoutActivity findById( Integer id) {
        log.debug("getting CarryoutActivity instance with id: " + id);
        try {
            CarryoutActivity instance = entityManager.find(CarryoutActivity.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

