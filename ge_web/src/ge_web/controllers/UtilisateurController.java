package ge_web.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.persistence.Parameter;
import javax.servlet.http.HttpServlet;

import dao.DaoInterface;
import ge_jpa.entities.Coordonnees;
import ge_jpa.entities.Role;
import ge_jpa.entities.Utilisateur;
import ge_web.sessionBeans.UserSessionBean;

@ManagedBean
public class UtilisateurController extends HttpServlet {

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
			UserSessionBean user = new UserSessionBean(utilisateur, new Date());
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
