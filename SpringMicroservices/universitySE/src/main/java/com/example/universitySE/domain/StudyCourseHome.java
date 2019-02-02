package com.example.universitySE.domain;
// Generated 31-gen-2019 19.40.01 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class StudyCourse.
 * @see StudyCourse
 * @author Hibernate Tools
 */
@Stateless
public class StudyCourseHome {

    private static final Log log = LogFactory.getLog(StudyCourseHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(StudyCourse transientInstance) {
        log.debug("persisting StudyCourse instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(StudyCourse persistentInstance) {
        log.debug("removing StudyCourse instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public StudyCourse merge(StudyCourse detachedInstance) {
        log.debug("merging StudyCourse instance");
        try {
            StudyCourse result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public StudyCourse findById( Integer id) {
        log.debug("getting StudyCourse instance with id: " + id);
        try {
            StudyCourse instance = entityManager.find(StudyCourse.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

