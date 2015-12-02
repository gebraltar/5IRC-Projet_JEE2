package ge_web.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import dao.DaoInterface;
import ge_jpa.entities.Ecole;
import ge_jpa.entities.TypeEcole;

@ManagedBean
@SessionScoped
public class EcoleController extends HttpServlet {

	@Inject
	private DaoInterface<Ecole> dao;
	@Inject
	private DaoInterface<TypeEcole> daoTypeEcole;
	
	private Ecole ecole ;
	private Ecole selectedEcole; 
	
    public EcoleController() {
    	ecole = new Ecole();
    }
    
    public Ecole getEcole() {
        return ecole;
    }
    
    public void setEcole(Ecole ecole){
    	this.ecole = ecole;
    }
    
    public Ecole getSelectedEcole() {
        return selectedEcole;
    }
    
    public void setSelectedEcole(Ecole ecole){
    	this.selectedEcole =ecole;
    }
    
	public List<Ecole> listEcole(){	
		try{
			return dao.list("SELECT e FROM Ecole e",null);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public List<TypeEcole> listTypeEcole(){	
		try{
			return daoTypeEcole.list("SELECT t FROM TypeEcole t",null);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public void addEcole() {
        dao.persist(ecole);
        FacesMessage message = new FacesMessage( "Ajout réussi !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
        ecole = new Ecole();
    }
	
	public void updateEcole() {
        dao.merge(selectedEcole);
        FacesMessage message = new FacesMessage( "Modification réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
    }
	
	public void resetSelectedEcole(){
		selectedEcole = null;
	}
	
	public void delete(Ecole e){
		dao.remove(e);
		FacesMessage message = new FacesMessage( "Suppression réussie !" );
        FacesContext.getCurrentInstance().addMessage( null, message );
	}
	
	public String gererEcoles() {
		return "ecoleView.xhtml?faces-redirect=true";
	}
}