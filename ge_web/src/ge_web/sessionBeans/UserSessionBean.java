package ge_web.sessionBeans;

import ge_jpa.entities.Utilisateur;

import java.io.Serializable;
import java.util.Date;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;

@javax.faces.bean.SessionScoped
public class UserSessionBean implements Serializable {

	private Utilisateur user;
	
	private Date dateConnexion;
	
	public int isAdmin = 0;
	
	public UserSessionBean(Utilisateur user, Date dateConnexion) {
		this.user = user;
		this.dateConnexion = dateConnexion;
		if(user.getRole().getRolId() == 1){
			this.isAdmin = 1;
		}
	}

	public Utilisateur getUser() {
		return user;
	}

	public void setUser(Utilisateur user) {
		this.user = user;
	}

	public Date getDateConnexion() {
		return dateConnexion;
	}

	public void setDateConnexion(Date dateConnexion) {
		this.dateConnexion = dateConnexion;
	}

	public int getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}

	
	
	
	

}
