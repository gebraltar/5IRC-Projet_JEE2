package ge_web.controllers;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class MenuController {
	
	public MenuController(){
			
	}
	
	public String redirectToIndex(){
		return "index.xhtml";
	}

	public String redirectToHome(){
		return "Home.xhtml";
	}
	
	public String redirectToAdminRef(){
		return "adminRefView.xhtml";
	}
	
	public String redirectToEcole(){
		return "ecoleView.xhtml";
	}
	
	public String redirectToNiveau(){
		return "nivScolaireView.xhtml";
	}
	
	public String redirectToSalle(){
		return "salleView.xhtml";
	}
	
	public String redirectToAdminUser(){
		return "adminUserView.xhtml";
	}
}
