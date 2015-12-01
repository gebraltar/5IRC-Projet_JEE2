package ge_web.controllers;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
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
		connecte=false;
		//List<Utilisateur> liste=dao.list("SELECT u FROM Utilisateur u WHERE u.utiLogin=:login AND u.utiPass=:mdp");
		List<Utilisateur> liste=dao.list("SELECT u FROM Utilisateur u");
		if(liste.isEmpty())
		{
			//rediriger vers une autre page d'erreur (Login ou mdp n'existe pas dans la BDD)
			connecte=false;
		}
		else
		{	//Si on récupere un utilisateur dans notre liste
			
			Iterator<Utilisateur> i = liste.iterator();
			while(i.hasNext()){
				Utilisateur temp = i.next();
				System.out.println(temp.getUtiLogin());
				
				if(temp.getUtiLogin().equals(login) && temp.getUtiPass().equals(mdp))
				{
				    this.utilisateur = temp;
					UserSessionBean user = new UserSessionBean(temp, new Date());
					res="index.xhtml";
					connecte=true;
					break;
				}
			}		
		}
		
		return res;	
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
		System.out.println("Set mdp !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+mdp);
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
		System.out.println("Set login !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!"+login);
	}

	public boolean isConnecte() {
		return connecte;
	}

	public void setConnecte(boolean connecte) {
		this.connecte = connecte;
	}


	

}
