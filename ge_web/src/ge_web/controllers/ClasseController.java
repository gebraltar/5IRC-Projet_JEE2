package ge_web.controllers;

import java.util.HashMap;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import dao.DaoInterface;
import ge_jpa.entities.Classe;
import ge_jpa.entities.Ecole;
import ge_jpa.entities.Niveau;

@ManagedBean
@SessionScoped
public class ClasseController extends HttpServlet {

	@Inject
	private DaoInterface<Classe> daoClasse;
	@Inject
	private DaoInterface<Niveau> daoNiveau;
	@Inject
	private DaoInterface<Ecole> daoEcole;
	private Classe classe;
	private Classe selectedClasse;
	private Ecole ecole;
	//private Niveau niveau;

	public ClasseController() {
		classe = new Classe();
		//niveau= new Niveau();
	}

	public Classe getSelectedClasse() {
		return selectedClasse;
	}

	public void setSelectedClasse(Classe selectedClasse) {
		this.selectedClasse = selectedClasse;
	}

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}
	/*public Niveau getNiveau() {
		return niveau;
	}

	public void setNiveau(Niveau niveau) {
		this.niveau = niveau;
	}*/
	public List<Classe> listClasse() {
		try {
			HashMap<String,Object> params=new HashMap<String, Object>();
			params.put("ecole", ecole.getEclId());
			return daoClasse.list("SELECT c FROM Classe c WHERE ECL_ID=:ecole ",params);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public List<Niveau> listNiveau() {
		try {
			return daoNiveau.list("SELECT n FROM Niveau n",null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	public void addClasse() {
		classe.setEcole(ecole);
		daoClasse.persist(classe);
		FacesMessage message = new FacesMessage("Ajout réussi !");
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public void updateClasse() {
		System.out.println(selectedClasse.getClsNumero());
		//selectedClasse.setNiveau(niveau);
		daoClasse.merge(selectedClasse);
		FacesMessage message = new FacesMessage("Modification sauvegarder !");
		FacesContext.getCurrentInstance().addMessage(null, message);
		selectedClasse=null;
	}

	public void deleteClasse(Classe classe) {
		daoClasse.remove(classe);
	}

	public void resetClasseSelected() {
		selectedClasse = null;
	}

	public String gererClasses(Ecole ecole) {
		this.ecole = ecole;
		return "classeView.xhtml?faces-redirect=true";
	}
}
