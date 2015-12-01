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
 * Service object for domain model class Professeur.
 * @see .Professeur
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class ProfesseurService implements DaoInterface<Professeur> {

	private static final Log log = LogFactory.getLog(ProfesseurService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Professeur transientInstance) {
		log.debug("persisting Professeur instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Professeur persistentInstance) {
		log.debug("removing Professeur instance");
		try {
			Professeur p = this.findById(persistentInstance.getPrfId());
			entityManager.remove(p);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Professeur merge(Professeur detachedInstance) {
		log.debug("merging Professeur instance");
		try {
			Professeur result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Professeur findById(Integer id) {
		log.debug("getting Professeur instance with id: " + id);
		try {
			Professeur instance = entityManager.find(Professeur.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<Professeur> list(String query) {
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
