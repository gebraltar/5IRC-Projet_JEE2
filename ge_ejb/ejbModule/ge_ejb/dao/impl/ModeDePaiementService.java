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
 * Service object for domain model class ModeDePaiement.
 * @see .ModeDePaiement
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless
public class ModeDePaiementService implements DaoInterface<ModeDePaiement> {

	private static final Log log = LogFactory.getLog(ModeDePaiementService.class);

	@PersistenceContext
	private EntityManager entityManager;

	public void persist(ModeDePaiement transientInstance) {
		log.debug("persisting ModeDePaiement instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(ModeDePaiement persistentInstance) {
		log.debug("removing ModeDePaiement instance");
		try {
			ModeDePaiement m = this.findById(persistentInstance.getMdpId());
			entityManager.remove(m);
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public ModeDePaiement merge(ModeDePaiement detachedInstance) {
		log.debug("merging ModeDePaiement instance");
		try {
			ModeDePaiement result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public ModeDePaiement findById(Integer id) {
		log.debug("getting ModeDePaiement instance with id: " + id);
		try {
			ModeDePaiement instance = entityManager.find(ModeDePaiement.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}
	
	@Override
	public List<ModeDePaiement> list(String query) {
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
