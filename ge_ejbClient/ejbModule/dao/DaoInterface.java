// default package
// Generated 18 nov. 2015 15:15:33 
//author : Alexandre Brosse

package dao;

import java.util.List;

import javax.ejb.Local;


@Local
public interface DaoInterface<T> {
	
	public void persist(T object);
	
	public void remove(T object);
	
	public T merge(T object);
	
	public T findById(Integer id);
	
	public List<T> list(String query);
}
