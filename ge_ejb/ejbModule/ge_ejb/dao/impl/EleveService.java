// default package
// Generated 18 nov. 2015 14:37:33 by Hibernate Tools 4.3.1.Final
//author : Alexandre Brosse

package ge_ejb.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import dao.DaoInterface;
import ge_jpa.entities.*;

/**
 * Service object for domain model class Eleve.
 * @see .Eleve
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class EleveService implements DaoInterface<Eleve>{

	private static final Log log = LogFactory.getLog(EleveService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Eleve transientInstance) {
		log.debug("persisting Eleve instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Eleve persistentInstance) {
		log.debug("removing Eleve instance");
		try {
			Eleve e = this.findById(persistentInstance.getElvId());
			entityManager.remove(e);
			
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Eleve merge(Eleve detachedInstance) {
		log.debug("merging Eleve instance");
		try {
			Eleve result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Eleve findById(Integer id) {
		log.debug("getting Eleve instance with id: " + id);
		try {
			Eleve instance = entityManager.find(Eleve.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Eleve> list(String query,HashMap<String, Object> params) {
		log.debug("getting list of "+this.getClass().toString()+" with query ["+query+"]");
		try {
			Query queryToExecute = entityManager.createQuery(query);
			if(params != null){
				for (Map.Entry<String, Object> item : params.entrySet()) {
					queryToExecute.setParameter(item.getKey(), item.getValue());
					log.debug("params["+item.getKey()+"]["+item.getValue()+"]");
				}
			}
			return queryToExecute.getResultList();
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
}
