package com.example.universitySE.domain;
// Generated 24-gen-2019 10.24.30 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Classroom.
 * @see Classroom
 * @author Hibernate Tools
 */
@Stateless
public class ClassroomHome {

    private static final Log log = LogFactory.getLog(ClassroomHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Classroom transientInstance) {
        log.debug("persisting Classroom instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Classroom persistentInstance) {
        log.debug("removing Classroom instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Classroom merge(Classroom detachedInstance) {
        log.debug("merging Classroom instance");
        try {
            Classroom result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Classroom findById( int id) {
        log.debug("getting Classroom instance with id: " + id);
        try {
            Classroom instance = entityManager.find(Classroom.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

