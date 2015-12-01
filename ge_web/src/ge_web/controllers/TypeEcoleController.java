package ge_web.controllers;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import dao.DaoInterface;
import ge_jpa.entities.TypeEcole;

/**
 * Session Bean implementation class Admin
 */
@ManagedBean
@SessionScoped
public class TypeEcoleController {

	private TypeEcole selectedTypeEcole;
	private TypeEcole typeEcoleToAdd;
	
	@Inject
	private DaoInterface<TypeEcole> dao;

	public TypeEcoleController(){
		this.typeEcoleToAdd = new TypeEcole();
	}
	
	public TypeEcole getSelectedTypeEcole() {
		return selectedTypeEcole;
	}

	public void setSelectedTypeEcole(TypeEcole typeEcole) {
		this.selectedTypeEcole = typeEcole;
	}
	
	public TypeEcole getTypeEcoleToAdd() {
		return this.typeEcoleToAdd;
	}

	public void setTypeEcoleToAdd(TypeEcole typeEcole) {
		this.typeEcoleToAdd = typeEcole;
	}
	
	public void resetSelectedTypeEcole() {
		this.selectedTypeEcole = null;
	}

	public void updateTypeEcole() {
		dao.merge(this.selectedTypeEcole);
	}
	
	public void removeTypeEcole(TypeEcole typeEcole) {
		dao.remove(typeEcole);
	}
	
	public List<TypeEcole> listTypeEcole(){
		return dao.list("SELECT t FROM TypeEcole t");	 
	}
	
	 public void addTypeEcole() {
         dao.persist(this.typeEcoleToAdd);
         this.typeEcoleToAdd = new TypeEcole();
         FacesMessage message = new FacesMessage( "Ajout réussi !" );
         FacesContext.getCurrentInstance().addMessage( null, message );
	 }

}
