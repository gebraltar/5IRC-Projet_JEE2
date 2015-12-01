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
 * Service object for domain model class Cours.
 * @see .Cours
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class CoursService implements DaoInterface<Cours>{

	private static final Log log = LogFactory.getLog(CoursService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Cours transientInstance) {
		log.debug("persisting Cours instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Cours persistentInstance) {
		log.debug("removing Cours instance");
		try {
			Cours c = this.findById(persistentInstance.getCrsId());
			entityManager.remove(c);
			
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Cours merge(Cours detachedInstance) {
		log.debug("merging Cours instance");
		try {
			Cours result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cours findById(Integer id) {
		log.debug("getting Cours instance with id: " + id);
		try {
			Cours instance = entityManager.find(Cours.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Cours> list(String query) {
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
