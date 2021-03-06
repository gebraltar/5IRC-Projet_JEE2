// default package
// Generated 18 nov. 2015 14:37:33 by Hibernate Tools 4.3.1.Final
//author : Alexandre Brosse

package ge_jpa.entities;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Salle generated by hbm2java
 */
@Entity
@Table(name = "salle", catalog = "sql496886")
public class Salle implements java.io.Serializable {

	private Integer salId;
	private Ecole ecole;
	private String salLabel;
	private Set<Cours> courses = new HashSet<Cours>(0);

	public Salle() {
	}

	public Salle(String salLabel) {
		this.salLabel = salLabel;
	}

	public Salle(String salLabel, Set<Cours> courses, Ecole ecole) {
		this.salLabel = salLabel;
		this.courses = courses;
		this.ecole = ecole;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "SAL_ID", unique = true, nullable = false)
	public Integer getSalId() {
		return this.salId;
	}

	public void setSalId(Integer salId) {
		this.salId = salId;
	}
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ECL_ID", nullable = false)
	public Ecole getEcole() {
		return ecole;
	}

	public void setEcole(Ecole ecole) {
		this.ecole = ecole;
	}

	@Column(name = "SAL_Label", nullable = false, length = 45)
	public String getSalLabel() {
		return this.salLabel;
	}

	public void setSalLabel(String salLabel) {
		this.salLabel = salLabel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "salle")
	public Set<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}

}
