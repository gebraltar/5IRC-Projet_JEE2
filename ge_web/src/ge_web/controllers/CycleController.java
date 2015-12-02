package ge_web.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
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
	}
	
	public void removeCycle(Cycle cycle) {
		dao.remove(cycle);
	}
	
	public List<Cycle> listCycle(){
		return dao.list("SELECT t FROM Cycle t", null);	 
	}
	
	 public void addCycle() {
         dao.persist(this.cycleToAdd);
         this.cycleToAdd = new Cycle();
	 }

}
