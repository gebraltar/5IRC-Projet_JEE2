package ge_web.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.SessionContext;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.Parameter;
import javax.servlet.http.HttpServlet;

import dao.DaoInterface;
import ge_jpa.entities.Coordonnees;
import ge_jpa.entities.Role;
import ge_jpa.entities.Utilisateur;
import ge_web.sessionBeans.UserSessionBean;

@ManagedBean
public class UtilisateurController {

	@Inject
	private DaoInterface<Utilisateur> dao;
	private String login;
	private String mdp;
	private boolean connecte=false;

	private Utilisateur utilisateur ;

    
    public UtilisateurController() {
    	utilisateur = new Utilisateur();
    }
    
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    
    public String Deconnexion(){
    	ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		
		Map<String, Object> sessionMap = externalContext.getSessionMap();
		sessionMap.remove("loggedUser");
    	return "index.xhtml";
    }
	
	public String Check_User()
	{
		String res="";
		HashMap<String, Object> params = new HashMap<String, Object>();
		params.put("login", login);
		params.put("password", mdp);
		List<Utilisateur> result=dao.list("SELECT u FROM Utilisateur u WHERE UTI_Login = :login AND UTI_Pass = :password",params);
		if(!result.isEmpty() && result.size() == 1)
		{	
		    this.utilisateur = result.get(0);
			
			// Retrieve the JSF memory space
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			
			Map<String, Object> sessionMap = externalContext.getSessionMap();
			// Place the user in the JSF memory space
			sessionMap.put("loggedUser", new UserSessionBean(utilisateur, new Date())); 
			res="Home.xhtml";	
		}
		if(res==""){
			///TODO afficher message erreur
			res="index.xhtml";
		}
		return res;	
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}

}
