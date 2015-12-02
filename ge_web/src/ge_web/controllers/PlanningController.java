package ge_web.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

import dao.DaoInterface;
import ge_jpa.entities.Classe;
import ge_jpa.entities.Cours;
import ge_jpa.entities.CrenauHoraire;
import ge_jpa.entities.Ecole;
import ge_jpa.entities.Professeur;
import ge_jpa.entities.Salle;


@ManagedBean
@SessionScoped
public class PlanningController extends HttpServlet {

	@Inject
	private DaoInterface<Cours> daoCours;
	private Classe classe;
	private ScheduleModel planning;
	
	public PlanningController() {
	}
	
	public ScheduleModel getPlanning() {
		return planning;
	}

	public void setPlanning(ScheduleModel planning) {
		this.planning = planning;
	}

	public void fillPlanning(){
		List<Cours> listCours;
		try {
			HashMap<String,Object> params=new HashMap<String, Object>();
			params.put("classe", classe.getClsId());
			listCours=daoCours.list("SELECT c FROM Cours c WHERE CLS_ID=:classe ",params);
			for(Cours c : listCours){
				Date debut =c.getCrenauHoraire().getCrhDateHeureDebut();
				Date fin =c.getCrenauHoraire().getCrhDateHeureFin();
				planning.addEvent(new DefaultScheduleEvent(c.getNom(),debut,fin));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	public String afficherPlanning(Classe classe) {
		planning=new DefaultScheduleModel();
		this.classe = classe;
		fillPlanning();
		return "planningView.xhtml?faces-redirect=true";
	}

}
