// default package
// Generated 18 nov. 2015 14:37:33 by Hibernate Tools 4.3.1.Final
//author : Alexandre Brosse

package ge_ejb.dao.impl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.DaoInterface;
import ge_jpa.entities.*;

/**
 * Service object for domain model class Coordonnees.
 * @see .Coordonnees
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class CoordonneesService implements DaoInterface<Coordonnees> {

	private static final Log log = LogFactory.getLog(CoordonneesService.class);

	@PersistenceContext
	private EntityManager entityManager;
	@Override
	public void persist(Coordonnees transientInstance) {
		log.debug("persisting Coordonnees instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}
	@Override
	public void remove(Coordonnees persistentInstance) {
		log.debug("removing Coordonnees instance");
		try {
			Coordonnees c = this.findById(persistentInstance.getCrdId());
			entityManager.remove(c);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}
	@Override
	public Coordonnees merge(Coordonnees detachedInstance) {
		log.debug("merging Coordonnees instance");
		try {
			Coordonnees result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}
	@Override
	public Coordonnees findById(Integer id) {
		log.debug("getting Coordonnees instance with id: " + id);
		try {
			Coordonnees instance = entityManager.find(Coordonnees.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<Coordonnees> list(String query) {
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
