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
 * Service object for domain model class Cheque.
 * @see .Cheque
 * @author Alexandre Brosse / Hibernate Tools
 */
@Stateless

public class ChequeService implements DaoInterface<Cheque> {

	private static final Log log = LogFactory.getLog(ChequeService.class);
	@PersistenceContext
	private EntityManager entityManager;
	
	public void persist(Cheque transientInstance) {
		log.debug("persisting Cheque instance");
		try {
			entityManager.persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void remove(Cheque persistentInstance) {
		log.debug("removing Cheque instance");
		try {
			Cheque c = this.findById(persistentInstance.getChqId());
			entityManager.remove(c);
			
			log.debug("remove successful");
		} catch (RuntimeException re) {
			log.error("remove failed", re);
			throw re;
		}
	}

	public Cheque merge(Cheque detachedInstance) {
		log.debug("merging Cheque instance");
		try {
			Cheque result = entityManager.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Cheque findById(Integer id) {
		log.debug("getting Cheque instance with id: " + id);
		try {
			Cheque instance = entityManager.find(Cheque.class, id);
			log.debug("get successful");
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@Override
	public List<Cheque> list(String query) {
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
