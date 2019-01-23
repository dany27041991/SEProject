package com.example.universitySE.domain;
// Generated 23-gen-2019 19.26.47 by Hibernate Tools 5.2.0.Final


import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Home object for domain model class ExchangeMessage.
 * @see ExchangeMessage
 * @author Hibernate Tools
 */
@Stateless
public class ExchangeMessageHome {

    private static final Log log = LogFactory.getLog(ExchangeMessageHome.class);

    @PersistenceContext private EntityManager entityManager;
    
    public void persist(ExchangeMessage transientInstance) {
        log.debug("persisting ExchangeMessage instance");
        try {
            entityManager.persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void remove(ExchangeMessage persistentInstance) {
        log.debug("removing ExchangeMessage instance");
        try {
            entityManager.remove(persistentInstance);
            log.debug("remove successful");
        }
        catch (RuntimeException re) {
            log.error("remove failed", re);
            throw re;
        }
    }
    
    public ExchangeMessage merge(ExchangeMessage detachedInstance) {
        log.debug("merging ExchangeMessage instance");
        try {
            ExchangeMessage result = entityManager.merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public ExchangeMessage findById( int id) {
        log.debug("getting ExchangeMessage instance with id: " + id);
        try {
            ExchangeMessage instance = entityManager.find(ExchangeMessage.class, id);
            log.debug("get successful");
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
}
