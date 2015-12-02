package ge_web.controllers;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import dao.DaoInterface;
import ge_jpa.entities.Classe;
import ge_jpa.entities.Cours;
import ge_jpa.entities.CrenauHoraire;
import ge_jpa.entities.Ecole;
import ge_jpa.entities.Professeur;
import ge_jpa.entities.Salle;


@ManagedBean
@SessionScoped
public class CoursController extends HttpServlet {

	@Inject
	private DaoInterface<Cours> daoCours;
	@Inject
	private DaoInterface<Professeur> daoProf;
	@Inject
	private DaoInterface<Salle> daoSalle;
	@Inject
	private DaoInterface<CrenauHoraire> daoCrenau;
	private Cours cours;
	private Cours selectedCours;
	private Classe classe;

	public CoursController() {
		cours = new Cours();
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public Cours getSelectedCours() {
		return selectedCours;
	}

	public void setSelectedCours(Cours selectedCours) {
		this.selectedCours = selectedCours;
	}

	public List<Cours> listCours() {
		try {
			HashMap<String,Object> params=new HashMap<String, Object>();
			params.put("classe", classe.getClsId());
			return daoCours.list("SELECT c FROM Cours c WHERE CLS_ID=:classe ",params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Professeur> listProfesseur() {
		try {
			return daoProf.list("SELECT p FROM Professeur p",null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public List<Salle> listSalle() {
		try {
			HashMap<String,Object> params=new HashMap<String, Object>();
			params.put("ecole", classe.getEcole().getEclId());
			return daoSalle.list("SELECT s FROM Salle s WHERE ECL_ID=:ecole ",params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void addCours() {
		CrenauHoraire crenauTmp=cours.getCrenauHoraire();
		crenauTmp.setCrhLabel("");
		daoCrenau.persist(crenauTmp);
		cours.setCrenauHoraire(crenauTmp);
		cours.setClasse(classe);
		daoCours.persist(cours);
		FacesMessage message = new FacesMessage("Ajout réussi !");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void updateCours() {
		daoCrenau.merge(selectedCours.getCrenauHoraire());
		daoCours.merge(selectedCours);
		FacesMessage message = new FacesMessage("Modification sauvegarder !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		selectedCours=null;
	}

	public void deleteCours(Cours cours) {
		daoCours.remove(cours);
	}

	public void resetCoursSelected() {
		selectedCours = null;
	}

	public String gererCours(Classe classe) {
		this.classe = classe;
		return "coursView.xhtml?faces-redirect=true";
	}

	public Classe getClasse() {
		return classe;
	}

	public void setEcole(Classe classe) {
		this.classe =classe;
	}
	
}
