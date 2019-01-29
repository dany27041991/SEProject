package com.example.universitySE.domain;
// Generated 29-gen-2019 8.53.03 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class SupportMaterial.
 * @see SupportMaterial
 * @author Hibernate Tools
 */
@Stateless
public class SupportMaterialHome {

    private static final Log log = LogFactory.getLog(SupportMaterialHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(SupportMaterial transientInstance) {
        log.debug("persisting SupportMaterial instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(SupportMaterial persistentInstance) {
        log.debug("removing SupportMaterial instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public SupportMaterial merge(SupportMaterial detachedInstance) {
        log.debug("merging SupportMaterial instance");
        try {
            SupportMaterial result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SupportMaterial findById( int id) {
        log.debug("getting SupportMaterial instance with id: " + id);
        try {
            SupportMaterial instance = entityManager.find(SupportMaterial.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

