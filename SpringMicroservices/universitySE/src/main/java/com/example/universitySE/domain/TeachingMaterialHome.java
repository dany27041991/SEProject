package com.example.universitySE.domain;
// Generated 28-gen-2019 15.27.51 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class TeachingMaterial.
 * @see TeachingMaterial
 * @author Hibernate Tools
 */
@Stateless
public class TeachingMaterialHome {

    private static final Log log = LogFactory.getLog(TeachingMaterialHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(TeachingMaterial transientInstance) {
        log.debug("persisting TeachingMaterial instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(TeachingMaterial persistentInstance) {
        log.debug("removing TeachingMaterial instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public TeachingMaterial merge(TeachingMaterial detachedInstance) {
        log.debug("merging TeachingMaterial instance");
        try {
            TeachingMaterial result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public TeachingMaterial findById( int id) {
        log.debug("getting TeachingMaterial instance with id: " + id);
        try {
            TeachingMaterial instance = entityManager.find(TeachingMaterial.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

