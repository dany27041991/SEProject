package com.example.universitySE.domain;
// Generated 8-feb-2019 18.41.44 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Subject.
 * @see Subject
 * @author Hibernate Tools
 */
@Stateless
public class SubjectHome {

    private static final Log log = LogFactory.getLog(SubjectHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Subject transientInstance) {
        log.debug("persisting Subject instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Subject persistentInstance) {
        log.debug("removing Subject instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Subject merge(Subject detachedInstance) {
        log.debug("merging Subject instance");
        try {
            Subject result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Subject findById( Integer id) {
        log.debug("getting Subject instance with id: " + id);
        try {
            Subject instance = entityManager.find(Subject.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

