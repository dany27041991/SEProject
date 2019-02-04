package com.example.universitySE.domain;
// Generated 3-feb-2019 20.09.15 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class DownloadTeachingMaterial.
 * @see DownloadTeachingMaterial
 * @author Hibernate Tools
 */
@Stateless
public class DownloadTeachingMaterialHome {

    private static final Log log = LogFactory.getLog(DownloadTeachingMaterialHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(DownloadTeachingMaterial transientInstance) {
        log.debug("persisting DownloadTeachingMaterial instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(DownloadTeachingMaterial persistentInstance) {
        log.debug("removing DownloadTeachingMaterial instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public DownloadTeachingMaterial merge(DownloadTeachingMaterial detachedInstance) {
        log.debug("merging DownloadTeachingMaterial instance");
        try {
            DownloadTeachingMaterial result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public DownloadTeachingMaterial findById( Integer id) {
        log.debug("getting DownloadTeachingMaterial instance with id: " + id);
        try {
            DownloadTeachingMaterial instance = entityManager.find(DownloadTeachingMaterial.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}

