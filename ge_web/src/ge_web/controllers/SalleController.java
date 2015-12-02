package ge_web.controllers;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
	@Inject
	private DaoInterface<Ecole> daoEcole;
	private Salle salle;
	private Salle selectedSalle;
	private Ecole ecole;

	public SalleController() {
		salle = new Salle();
	}
	public String gererSalles(Ecole ecole) {
		this.ecole = ecole;
		return "salleView.xhtml?faces-redirect=true";
	}
}
