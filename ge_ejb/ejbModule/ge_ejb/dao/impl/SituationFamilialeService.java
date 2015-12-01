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
 * Service object for domain model class SituationFamiliale.
 * @see .SituationFamiliale
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class SituationFamilialeService implements DaoInterface<SituationFamiliale> {

	private static final Log log = LogFactory.getLog(SituationFamilialeService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(SituationFamiliale transientInstance) {
		log.debug("persisting SituationFamiliale instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(SituationFamiliale persistentInstance) {
		log.debug("removing SituationFamiliale instance");
		try {
			SituationFamiliale s = this.findById(persistentInstance.getSfaId());
			entityManager.remove(s);
			
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public SituationFamiliale merge(SituationFamiliale detachedInstance) {
		log.debug("merging SituationFamiliale instance");
		try {
			SituationFamiliale result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SituationFamiliale findById(Integer id) {
		log.debug("getting SituationFamiliale instance with id: " + id);
		try {
			SituationFamiliale instance = entityManager.find(SituationFamiliale.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<SituationFamiliale> list(String query,HashMap<String, Object> params) {
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
