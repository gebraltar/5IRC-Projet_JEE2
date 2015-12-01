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
 * Service object for domain model class Cycle.
 * @see .Cycle
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class CycleService implements DaoInterface<Cycle> {

	private static final Log log = LogFactory.getLog(CycleService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Cycle transientInstance) {
		log.debug("persisting Cycle instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Cycle persistentInstance) {
		log.debug("removing Cycle instance");
		try {
			Cycle c = this.findById(persistentInstance.getCclId());
			entityManager.remove(c);
			
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Cycle merge(Cycle detachedInstance) {
		log.debug("merging Cycle instance");
		try {
			Cycle result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cycle findById(Integer id) {
		log.debug("getting Cycle instance with id: " + id);
		try {
			Cycle instance = entityManager.find(Cycle.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<Cycle> list(String query) {
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
