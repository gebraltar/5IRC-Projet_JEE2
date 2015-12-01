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
 * Service object for domain model class TypeEcole.
 * @see .TypeEcole
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class TypeEcoleService implements DaoInterface<TypeEcole> {

	private static final Log log = LogFactory.getLog(TypeEcoleService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(TypeEcole transientInstance) {
		log.debug("persisting TypeEcole instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(TypeEcole persistentInstance) {
		log.debug("removing TypeEcole instance");
		try {
			entityManager.remove(persistentInstance);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public TypeEcole merge(TypeEcole detachedInstance) {
		log.debug("merging TypeEcole instance");
		try {
			TypeEcole result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public TypeEcole findById(Integer id) {
		log.debug("getting TypeEcole instance with id: " + id);
		try {
			TypeEcole instance = entityManager.find(TypeEcole.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<TypeEcole> list(String query) {
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
