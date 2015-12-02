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
import ge_jpa.entities.Ecole;
import ge_jpa.entities.Salle;

@ManagedBean
@SessionScoped
public class SalleController extends HttpServlet {

	@Inject
	private DaoInterface<Salle> daoSalle;
	private Salle salle;
	private Salle selectedSalle;
	private Ecole ecole;

	public SalleController() {
		salle = new Salle();
	}
	
	public Salle getSelectedSalle() {
		return selectedSalle;
	}

	public void setSelectedSalle(Salle selectedSalle) {
		this.selectedSalle = selectedSalle;
	}

	public Salle getSalle() {
		return salle;
	}

	public void setSalle(Salle salle) {
		this.salle = salle;
	}
	
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}
	
	public List<Salle> listSalle() {
		try {
			HashMap<String, Object> params = new HashMap<String, Object>();
			params.put("ecole", ecole.getEclId());
			return daoSalle.list("SELECT s FROM Salle s WHERE ECL_ID = :ecole ",params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}
	
	public void addSalle() {
		salle.setEcole(ecole);
		daoSalle.persist(salle);
		salle = new Salle();
		FacesMessage message = new FacesMessage("Ajout réussi !");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void updateSalle() {
		daoSalle.merge(selectedSalle);
		FacesMessage message = new FacesMessage("Modification réussie !");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void deleteSalle(Salle salle) {
		daoSalle.remove(salle);
		FacesMessage message = new FacesMessage( "Suppression réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
	}

	public void resetSalleSelected() {
		selectedSalle = null;
	}
	public String gererSalles(Ecole ecole) {
		this.ecole = ecole;
		return "salleView.xhtml?faces-redirect=true";
	}
}
