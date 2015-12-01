package ge_web.controllers;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;
import javax.servlet.http.HttpServlet;

import dao.DaoInterface;
import ge_jpa.entities.Coordonnees;

@ManagedBean
public class TestController extends HttpServlet {

	@Inject
	private DaoInterface<Coordonnees> dao;
	
	public void Test(){
		Coordonnees c = new Coordonnees("rue des chats", null, "69100", "Villeurbanne", null, null, "0651245896", "test@test.fr");
	
		try{
			dao.persist(c);
			//List<Coordonnees> l = dao.list("Select c from Coordonnees c");
			//c.setCrdAdresseLigne1("rue jean jean");
			//dao.merge(c);
			//c = dao.findById(8);
			//dao.remove(c);
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
	}

}
