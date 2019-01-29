package com.example.universitySE.domain;
<<<<<<< HEAD
// Generated 28-gen-2019 15.27.51 by Hibernate Tools 5.2.0.Final
=======
// Generated 29-gen-2019 8.53.03 by Hibernate Tools 5.2.0.Final
>>>>>>> master


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Activity.
 * @see Activity
 * @author Hibernate Tools
 */
@Stateless
public class ActivityHome {

    private static final Log log = LogFactory.getLog(ActivityHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Activity transientInstance) {
        log.debug("persisting Activity instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Activity persistentInstance) {
        log.debug("removing Activity instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Activity merge(Activity detachedInstance) {
        log.debug("merging Activity instance");
        try {
            Activity result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Activity findById( int id) {
        log.debug("getting Activity instance with id: " + id);
        try {
            Activity instance = entityManager.find(Activity.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

