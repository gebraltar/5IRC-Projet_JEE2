package ge_web.sessionBeans;

import ge_jpa.entities.Utilisateur;

import java.io.Serializable;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
@SessionScoped
public class UserSessionBean implements Serializable {

	private Utilisateur user;
	
	private Date dateConnexion;
	
	public UserSessionBean(Utilisateur user, Date dateConnexion) {
		this.user = user;
		this.dateConnexion = dateConnexion;
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
	
	

}
