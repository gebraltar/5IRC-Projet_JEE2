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
 * Service object for domain model class Classe.
 * @see .Classe
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class ClasseService implements DaoInterface<Classe> {

	private static final Log log = LogFactory.getLog(ClasseService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(Classe transientInstance) {
		log.debug("persisting Classe instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Classe persistentInstance) {
		log.debug("removing Classe instance");
		try {
			Classe c = this.findById(persistentInstance.getClsId());
			entityManager.remove(c);
			log.debug("remove successful");
		} catch (Exception re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Classe merge(Classe detachedInstance) {
		log.debug("merging Classe instance");
		try {
			Classe result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Classe findById(Integer id) {
		log.debug("getting Classe instance with id: " + id);
		try {
			Classe instance = entityManager.find(Classe.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Classe> list(String query,HashMap<String, Object> params) {
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
