package ge_web.controllers;

import java.util.HashMap;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import dao.DaoInterface;
import ge_jpa.entities.Cycle;
import ge_jpa.entities.Niveau;

/**
 * Session Bean controller pour les niveaux scolaires
 */
@ManagedBean
@SessionScoped
public class NivScolaireController {

	private Niveau selectedNivScolaire;
	private Niveau nivScolaireToAdd;
	private Cycle cycleParent;
	
	@Inject
	private DaoInterface<Niveau> dao;

	public NivScolaireController(){
		this.nivScolaireToAdd = new Niveau();
	}
	
	public Niveau getSelectedNivScolaire() {
		return this.selectedNivScolaire;
	}

	public void setSelectedNivScolaire(Niveau nivScolaire) {
		this.selectedNivScolaire = nivScolaire;
	}
	
	public Niveau getNivScolaireToAdd() {
		return this.nivScolaireToAdd;
	}

	public void setNivScolaireToAdd(Niveau nivScolaire) {
		this.nivScolaireToAdd = nivScolaire;
	}
	
	public Cycle getCycleParent() {
		return this.cycleParent;
	}

	public void setCycleParent(Cycle cycle) {
		this.cycleParent = cycle;
	}
	
	public void resetSelectedNivScolaire() {
		this.selectedNivScolaire = null;
	}

	public void updateNivScolaire() {
		dao.merge(this.selectedNivScolaire);
		resetSelectedNivScolaire();
	}
	
	public void removeNivScolaire(Niveau nivScolaire) {
		dao.remove(nivScolaire);
	}
	
	public List<Niveau> listNivScolaire(){
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("cclId", cycleParent.getCclId());
		return dao.list("SELECT n FROM Niveau n WHERE CCL_ID = :cclId",params); 
	}
	
	 public void addNivScolaire() {
		 this.nivScolaireToAdd.setCycle(this.cycleParent);
         dao.persist(this.nivScolaireToAdd);
         this.nivScolaireToAdd = new Niveau();
	 }
	 
	 public String gererNivScolaire(Cycle cycle){
		 this.cycleParent = cycle;
		 return "nivScolaireView.xhtml?faces-redirect=true";
	 }
	 
	 public String goToAdminRef(){
		 return "adminRefView.xhtml?faces-redirect=true";
	 }
}
