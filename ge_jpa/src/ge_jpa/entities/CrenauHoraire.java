// default package
// Generated 18 nov. 2015 14:37:33 by Hibernate Tools 4.3.1.Final
//author : Alexandre Brosse

package ge_jpa.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * CrenauHoraire generated by hbm2java
 */
@Entity
@Table(name = "crenau_horaire", catalog = "sql496886")
public class CrenauHoraire implements java.io.Serializable {

	private Integer crhId;
	private String crhLabel;
	private Date crhDateHeureFin;
	private Date crhDateHeureDebut;
	private Set<Cours> courses = new HashSet<Cours>(0);

	public CrenauHoraire() {
	}

	public CrenauHoraire(String crhLabel) {
		this.crhLabel = crhLabel;
	}

	public CrenauHoraire(String crhLabel, Date crhDateHeureFin, Date crhDateHeureDebut, Set<Cours> courses) {
		this.crhLabel = crhLabel;
		this.crhDateHeureFin = crhDateHeureFin;
		this.crhDateHeureDebut = crhDateHeureDebut;
		this.courses = courses;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "CRH_ID", unique = true, nullable = false)
	public Integer getCrhId() {
		return this.crhId;
	}

	public void setCrhId(Integer crhId) {
		this.crhId = crhId;
	}

	@Column(name = "CRH_Label", nullable = false, length = 45)
	public String getCrhLabel() {
		return this.crhLabel;
	}

	public void setCrhLabel(String crhLabel) {
		this.crhLabel = crhLabel;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRH_Date_Heure_Fin", length = 19)
	public Date getCrhDateHeureFin() {
		return this.crhDateHeureFin;
	}

	public void setCrhDateHeureFin(Date crhDateHeureFin) {
		this.crhDateHeureFin = crhDateHeureFin;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "CRH_Date_Heure_Debut", length = 19)
	public Date getCrhDateHeureDebut() {
		return this.crhDateHeureDebut;
	}

	public void setCrhDateHeureDebut(Date crhDateHeureDebut) {
		this.crhDateHeureDebut = crhDateHeureDebut;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "crenauHoraire")
	public Set<Cours> getCourses() {
		return this.courses;
	}

	public void setCourses(Set<Cours> courses) {
		this.courses = courses;
	}

}
