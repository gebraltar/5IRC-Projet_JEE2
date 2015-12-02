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
 * Service object for domain model class CrenauHoraire.
 * @see .CrenauHoraire
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class CrenauHoraireService implements DaoInterface<CrenauHoraire> {

	private static final Log log = LogFactory.getLog(CrenauHoraireService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(CrenauHoraire transientInstance) {
		log.debug("persisting CrenauHoraire instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(CrenauHoraire persistentInstance) {
		log.debug("removing CrenauHoraire instance");
		try {
			CrenauHoraire c = this.findById(persistentInstance.getCrhId());
			entityManager.remove(c);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public CrenauHoraire merge(CrenauHoraire detachedInstance) {
		log.debug("merging CrenauHoraire instance");
		try {
			CrenauHoraire result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (Exception re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public CrenauHoraire findById(Integer id) {
		log.debug("getting CrenauHoraire instance with id: " + id);
		try {
			CrenauHoraire instance = entityManager.find(CrenauHoraire.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<CrenauHoraire> list(String query,HashMap<String, Object> params) {
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
