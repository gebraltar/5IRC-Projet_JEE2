package ge_web.controllers;

import java.util.HashMap;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.print.attribute.standard.Severity;

import dao.DaoInterface;
import ge_jpa.entities.Role;
import ge_jpa.entities.Utilisateur;;

/**
 * Session Bean implementation class Admin
 */
@ManagedBean
@SessionScoped
public class AdminUtilisateurController {
	
	private Utilisateur selectedUser;
	
	private Utilisateur userToAdd;
	private String verifPass;
	private Role role;
	
	@Inject
	private DaoInterface<Utilisateur> dao;

	@Inject
	private DaoInterface<Role> daoRole;
	
	public AdminUtilisateurController(){
		this.userToAdd = new Utilisateur();
		verifPass = "";
		role = new Role();
	}
	
	public Utilisateur getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(Utilisateur user) {
		this.selectedUser = user;
	}
	
	public Utilisateur getUserToAdd() {
		return this.userToAdd;
	}

	public void setUserToAdd(Utilisateur user) {
		this.userToAdd = user;
	}
	
	public void resetSelectedUser() {
		this.selectedUser = null;
	}

	public void updateUser() {
		selectedUser.setRole(this.role);
		dao.merge(this.selectedUser);
		FacesMessage message;
		message = new FacesMessage( "Mise � jour effecut�e !" );
        message.setDetail("");
		FacesContext.getCurrentInstance().addMessage( null, message );
	}
	
	public void removeUser(Utilisateur user) {
		dao.remove(user);
		FacesMessage message;
		message = new FacesMessage( "L'utilisateur "+user.getUtiLogin()+" a �t� supprim�  !" );
        message.setDetail("");
		FacesContext.getCurrentInstance().addMessage( null, message );

	}
	
	public List<Utilisateur> listUsers(){
		return dao.list("SELECT u FROM Utilisateur u",null);	 
	}
	
	public List<Role> listRole(){
		return daoRole.list("SELECT r FROM Role r",null);	 
	}
	
	 public void addUser() {
		 FacesMessage message;
		 if(this.verifPass.equals(userToAdd.getUtiPass())){
			 HashMap<String, Object> params = new HashMap<String, Object>();
			 params.put("login", userToAdd.getUtiLogin());
			 List<Utilisateur> exists = dao.list("SELECT u FROM Utilisateur u WHERE UTI_Login= :login",params);
			 if(exists != null && exists.isEmpty()){
				 dao.persist(this.userToAdd);
		         this.userToAdd = new Utilisateur();    
		         message = new FacesMessage( "Ajout r�ussi !" );
		         message.setDetail("");
			 }else{
				 message = new FacesMessage( "Un utilisateur avec ce login existe d�j� !" );
		         message.setDetail("");
		         message.setSeverity(javax.faces.application.FacesMessage.SEVERITY_ERROR);
			 }
		 }else{
			 message = new FacesMessage("Les 2 mots de passe ne sont pas identiques");
			 message.setDetail("");
			 message.setSeverity(javax.faces.application.FacesMessage.SEVERITY_ERROR);
		 }
		 FacesContext.getCurrentInstance().addMessage( null, message );
		 
	 }

	public String getVerifPass() {
		return verifPass;
	}

	public void setVerifPass(String verifPass) {
		this.verifPass = verifPass;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	 
	 

}
