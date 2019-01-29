package com.example.universitySE.domain;
// Generated 28-gen-2019 15.27.51 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class PersonType.
 * @see PersonType
 * @author Hibernate Tools
 */
@Stateless
public class PersonTypeHome {

    private static final Log log = LogFactory.getLog(PersonTypeHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(PersonType transientInstance) {
        log.debug("persisting PersonType instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(PersonType persistentInstance) {
        log.debug("removing PersonType instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public PersonType merge(PersonType detachedInstance) {
        log.debug("merging PersonType instance");
        try {
            PersonType result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public PersonType findById( int id) {
        log.debug("getting PersonType instance with id: " + id);
        try {
            PersonType instance = entityManager.find(PersonType.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

