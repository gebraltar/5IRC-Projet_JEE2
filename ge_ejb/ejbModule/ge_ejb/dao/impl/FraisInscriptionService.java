// default package
// Generated 18 nov. 2015 14:37:33 by Hibernate Tools 4.3.1.Final
//author : Alexandre Brosse

package ge_ejb.dao.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.DaoInterface;
import ge_jpa.entities.*;

/**
 * Service object for domain model class FraisInscription.
 * @see .FraisInscription
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class FraisInscriptionService implements DaoInterface<FraisInscription> {

	private static final Log log = LogFactory.getLog(FraisInscriptionService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(FraisInscription transientInstance) {
		log.debug("persisting FraisInscription instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(FraisInscription persistentInstance) {
		log.debug("removing FraisInscription instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public FraisInscription merge(FraisInscription detachedInstance) {
		log.debug("merging FraisInscription instance");
		try {
			FraisInscription result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public FraisInscription findById(Integer id) {
		log.debug("getting FraisInscription instance with id: " + id);
		try {
			FraisInscription instance = entityManager.find(FraisInscription.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<FraisInscription> list(String query) {
		log.debug("getting list of "+this.getClass().toString()+" with query ["+query+"]");
		try {
			Query queryToExecute = entityManager.createQuery(query);
			return queryToExecute.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
