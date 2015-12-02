package ge_web.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PersistenceException;
import javax.transaction.RollbackException;
import javax.validation.ConstraintViolationException;

import dao.DaoInterface;
import ge_jpa.entities.Cycle;

/**
 * Session Bean implementation class Cycle
 */
@ManagedBean
@SessionScoped
public class CycleController {

	private Cycle selectedCycle;
	private Cycle cycleToAdd;
	
	@Inject
	private DaoInterface<Cycle> dao;

	public CycleController(){
		this.cycleToAdd = new Cycle();
	}
	
	public Cycle getSelectedCycle() {
		return selectedCycle;
	}

	public void setSelectedCycle(Cycle cycle) {
		this.selectedCycle = cycle;
	}
	
	public Cycle getCycleToAdd() {
		return this.cycleToAdd;
	}

	public void setCycleToAdd(Cycle cycle) {
		this.cycleToAdd = cycle;
	}
	
	public void resetSelectedCycle() {
		this.selectedCycle = null;
	}

	public void updateCycle() {
		dao.merge(this.selectedCycle);
		resetSelectedCycle();
        FacesMessage message = new FacesMessage( "Mise à jour réussie !" );
        message.setDetail("");
		//message.setSeverity(javax.faces.application.FacesMessage.SEVERITY_ERROR);
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	
	public void removeCycle(Cycle cycle) {
		FacesMessage message;
		dao.remove(cycle);
		message = new FacesMessage( "Suppression réussie !" );
	    message.setDetail("");
	    FacesContext.getCurrentInstance().addMessage( null, message );
		
	}
	
	public List<Cycle> listCycle(){
		return dao.list("SELECT t FROM Cycle t", null);	 
	}
	
	 public void addCycle() {
         dao.persist(this.cycleToAdd);
         this.cycleToAdd = new Cycle();
         FacesMessage message = new FacesMessage( "Suppression réussie !" );
         message.setDetail("");
 		 //message.setSeverity(javax.faces.application.FacesMessage.SEVERITY_ERROR);
         FacesContext.getCurrentInstance().addMessage( null, message );
	 }
}
