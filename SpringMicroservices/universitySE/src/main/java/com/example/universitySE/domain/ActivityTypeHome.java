package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.15 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ActivityType.
 * @see ActivityType
 * @author Hibernate Tools
 */
@Stateless
public class ActivityTypeHome {

    private static final Log log = LogFactory.getLog(ActivityTypeHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(ActivityType transientInstance) {
        log.debug("persisting ActivityType instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(ActivityType persistentInstance) {
        log.debug("removing ActivityType instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public ActivityType merge(ActivityType detachedInstance) {
        log.debug("merging ActivityType instance");
        try {
            ActivityType result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ActivityType findById( Integer id) {
        log.debug("getting ActivityType instance with id: " + id);
        try {
            ActivityType instance = entityManager.find(ActivityType.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

