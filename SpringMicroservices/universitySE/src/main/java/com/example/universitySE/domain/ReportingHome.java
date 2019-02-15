package com.example.universitySE.domain;
// Generated 14-feb-2019 21.58.41 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Reporting.
 * @see Reporting
 * @author Hibernate Tools
 */
@Stateless
public class ReportingHome {

    private static final Log log = LogFactory.getLog(ReportingHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Reporting transientInstance) {
        log.debug("persisting Reporting instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Reporting persistentInstance) {
        log.debug("removing Reporting instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Reporting merge(Reporting detachedInstance) {
        log.debug("merging Reporting instance");
        try {
            Reporting result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Reporting findById( Integer id) {
        log.debug("getting Reporting instance with id: " + id);
        try {
            Reporting instance = entityManager.find(Reporting.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

