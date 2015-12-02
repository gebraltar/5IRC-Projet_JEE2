package ge_web.controllers;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import dao.DaoInterface;
import ge_jpa.entities.Civilite;
import ge_jpa.entities.Classe;
import ge_jpa.entities.Coordonnees;
import ge_jpa.entities.Ecole;
import ge_jpa.entities.Eleve;
import ge_jpa.entities.Responsable;
import ge_jpa.entities.SituationFamiliale;

/**
 * Session Bean implementation class Eleve
 */
@ManagedBean
@SessionScoped
public class InscriptionEleveController {
	
	private Eleve selectedEleve;
	private Eleve eleveToAdd;
	private Responsable selectedResponsable;
	private Responsable responsableToAdd;

	private Coordonnees coordonneesToAdd;
	
	private Classe classe;
	private SituationFamiliale situationFamiliale;
	private Civilite civilite;
	
	@Inject
	private DaoInterface<Eleve> daoEl;

	@Inject
	private DaoInterface<Classe> daoCla;
	
	@Inject
	private DaoInterface<Responsable> daoRes;
	
	@Inject
	private DaoInterface<Coordonnees> daoCor;
	
	@Inject
	private DaoInterface<SituationFamiliale> daoFam;
	
	@Inject
	private DaoInterface<Civilite> daoCiv;
	
	public InscriptionEleveController(){
		eleveToAdd = new Eleve();
		classe = new Classe();
		responsableToAdd = new Responsable();
		coordonneesToAdd = new Coordonnees();
		civilite = new Civilite();
		situationFamiliale = new SituationFamiliale();
		
	}
	
	public Eleve getSelectedEleve() {
		return selectedEleve;
	}

	public void setSelectedEleve(Eleve el) {
		this.selectedEleve = el;
	}
	
	public Eleve getEleveToAdd() {
		return this.eleveToAdd;
	}

	public void setEleveToAdd(Eleve el) {
		this.eleveToAdd = el;
	}
	
	public void resetSelectedEleve() {
		this.selectedEleve = null;
	}

	public void updateEleve() {
		updateCoordonnees();
		updateResponsable();
		//selectedEleve.setClasse(this.classe);
		daoEl.merge(this.selectedEleve);
		FacesMessage message = new FacesMessage( "Modification réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        resetSelectedEleve();
        
	}
	
	public void removeEleve(Eleve eleve) {
		
		
		
		Iterator<Responsable> i = eleve.getResponsables().iterator();
		Responsable r = null;
		while(i.hasNext()){
			r =(Responsable) i.next();
		}
		
		removeResponsable(r);
		removeCoordonnees(r.getCoordonnees());	
		daoEl.remove(eleve);
		
	
		
		FacesMessage message = new FacesMessage( "Suppresion réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	public Responsable getResponsablebyIdEleve(int idEleve)
	{
			try {
		            HashMap<String, Object> params = new HashMap<String, Object>();
		            params.put("eleve", idEleve);
		            List<Responsable> liste= daoRes.list("SELECT r FROM Responsable r WHERE ELV_ID = :eleve ",params);
		            return liste.get(0);
		    } catch (Exception e) {
		            System.out.println(e.getMessage());
		            return null;
		    }
	}
	/*
	public Coordonnees getRCoordonneesbyIdRes(int idRes)
	{
			try {
		            HashMap<String, Object> params = new HashMap<String, Object>();
		            params.put("res", idRes);
		            List<Coordonnees> liste= daoCor.list("SELECT c FROM Coordonnees c WHERE CRD_ID = :res ",params);
		            selectedCoordonnees=liste.get(0);
		            return liste.get(0);
		    } catch (Exception e) {
		            System.out.println(e.getMessage());
		            return null;
		    }
	}
	*/
	public Responsable getSelectedResponsable() {
		return selectedResponsable;
		
	}

	public void setSelectedResponsable(Responsable res) {
		this.selectedResponsable = res;
	}
	
	public Responsable getResponsableToAdd() {
		return this.responsableToAdd;
	}

	public void setResponsableToAdd(Responsable res) {
		this.responsableToAdd = res;
	}
	
	public void resetSelectedResponsable() {
		this.selectedResponsable = null;
	}

	public void updateResponsable() {
		daoRes.merge(this.selectedResponsable);
		FacesMessage message = new FacesMessage( "Modification réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	
	public void removeResponsable(Responsable responsable) {
		daoRes.remove(responsable);
	}
	/*
	public Coordonnees getSelectedCoordonnees() {
		return selectedCoordonnees;
		
	}

	public void setSelectedCoordonnees(Coordonnees coord) {
		this.selectedCoordonnees = coord;
	}
	*/
	public Coordonnees getCoordonneesToAdd() {
		return this.coordonneesToAdd;
	}

	public void setCoordonneesToAdd(Coordonnees coord) {
		this.coordonneesToAdd = coord;
	}
	/*
	public void resetSelectedCoordonnees() {
		this.selectedCoordonnees = null;
	}
	 */
	public void updateCoordonnees() {
		daoCor.merge(selectedResponsable.getCoordonnees());
	}
	
	public void removeCoordonnees(Coordonnees coordonnes) {
		daoCor.remove(coordonnes);
		FacesMessage message = new FacesMessage( "Suppresion réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	
	public List<Eleve> listEleves(){
		
		 HashMap<String, Object> params = new HashMap<String, Object>();
         params.put("id", classe.getClsId());
         List<Eleve> liste= daoEl.list("SELECT e FROM Eleve e WHERE CLA_ID = :id ",params);
         return liste; 
	}
	
	public List<Classe> listClasse(){
		return daoCla.list("SELECT c FROM Classe c",null);	 
	}
	
	public List<Civilite> listCivilite(){
		return daoCiv.list("SELECT c FROM Civilite c",null);	 
	}
	
	public List<SituationFamiliale> listSituationFamiliale(){
		return daoFam.list("SELECT f FROM SituationFamiliale f",null);	 
	}
	
	 public void addEleve() {
		 FacesMessage message;
		 	eleveToAdd.setClasse(classe);
	         daoEl.persist(this.eleveToAdd);
	         
	         HashMap<String, Object> params = new HashMap<String, Object>();
	            params.put("nom", eleveToAdd.getElvNom());
	            params.put("prenom", eleveToAdd.getElvPrenom());
	            List<Eleve> liste= daoEl.list("SELECT e FROM Eleve e WHERE ELV_Nom = :nom AND ELV_Prenom = :prenom ",params);
	         responsableToAdd.setEleve(liste.get(0));
	         
	         daoCor.persist(this.coordonneesToAdd);
	         
	         HashMap<String, Object> params1 = new HashMap<String, Object>();
	            params1.put("adr", coordonneesToAdd.getCrdAdresseLigne1());
	            params1.put("cp", coordonneesToAdd.getCrdCodePostal());
	            List<Coordonnees> listec= daoCor.list("SELECT c FROM Coordonnees c WHERE CRD_Adresse_Ligne_1 = :adr AND CRD_Code_Postal = :cp ",params1);
	         responsableToAdd.setCoordonnees(listec.get(0));
	         
	         daoRes.persist(this.responsableToAdd);
	         this.eleveToAdd = new Eleve();
	         message = new FacesMessage( "Ajout réussi !" );
	         message.setDetail("");
	 }

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	
	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civ) {
		this.civilite = civ;
	}
	
	public SituationFamiliale getSituationFamiliale() {
		return situationFamiliale;
	}

	public void setSituationFamiliale(SituationFamiliale sitFam) {
		this.situationFamiliale = sitFam;
	}
	public String gererEleves(Classe classe) {
		this.classe = classe;
		return "eleveView.xhtml?faces-redirect=true";
	}
	 
	 

}
