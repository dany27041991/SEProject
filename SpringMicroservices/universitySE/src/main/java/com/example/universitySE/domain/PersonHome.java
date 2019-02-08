package com.example.universitySE.domain;
<<<<<<< HEAD
// Generated 2-feb-2019 18.39.10 by Hibernate Tools 5.2.0.Final
=======
// Generated 3-feb-2019 20.09.15 by Hibernate Tools 5.2.0.Final
>>>>>>> master


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class Person.
 * @see Person
 * @author Hibernate Tools
 */
@Stateless
public class PersonHome {

    private static final Log log = LogFactory.getLog(PersonHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(Person transientInstance) {
        log.debug("persisting Person instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(Person persistentInstance) {
        log.debug("removing Person instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public Person merge(Person detachedInstance) {
        log.debug("merging Person instance");
        try {
            Person result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Person findById( Integer id) {
        log.debug("getting Person instance with id: " + id);
        try {
            Person instance = entityManager.find(Person.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

