package com.example.universitySE.domain;
// Generated 2-feb-2019 18.45.38 by Hibernate Tools 5.2.0.Final


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Home object for domain model class Faculty.
 * @see Faculty
 * @author Hibernate Tools
 */
@Stateless
public class FacultyHome {

    private static final Log log = LogFactory.getLog(FacultyHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Faculty transientInstance) {
        log.debug("persisting Faculty instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Faculty persistentInstance) {
        log.debug("removing Faculty instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Faculty merge(Faculty detachedInstance) {
        log.debug("merging Faculty instance");
        try {
            Faculty result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Faculty findById( Integer id) {
        log.debug("getting Faculty instance with id: " + id);
        try {
            Faculty instance = entityManager.find(Faculty.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

