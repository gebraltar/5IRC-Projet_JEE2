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
 * Niveau generated by hbm2java
 */
@Entity
@Table(name = "niveau", catalog = "sql496886")
public class Niveau implements java.io.Serializable {

	private Integer nivId;
	private Cycle cycle;
	private String nivLabel;
	private Set<Classe> classes = new HashSet<Classe>(0);

	public Niveau() {
	}

	public Niveau(Cycle cycle, String nivNiveauLabel) {
		this.cycle = cycle;
		this.nivLabel = nivNiveauLabel;
	}

	public Niveau(Cycle cycle, String nivNiveauLabel, Set<Classe> classes) {
		this.cycle = cycle;
		this.nivLabel = nivNiveauLabel;
		this.classes = classes;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "NIV_ID", unique = true, nullable = false)
	public Integer getNivId() {
		return this.nivId;
	}

	public void setNivId(Integer nivId) {
		this.nivId = nivId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CCL_ID", nullable = false)
	public Cycle getCycle() {
		return this.cycle;
	}

	public void setCycle(Cycle cycle) {
		this.cycle = cycle;
	}

	@Column(name = "NIV_Label", nullable = false, length = 45)
	public String getNiveauLabel() {
		return this.nivLabel;
	}

	public void setNiveauLabel(String nivNiveauLabel) {
		this.nivLabel = nivNiveauLabel;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "niveau")
	public Set<Classe> getClasses() {
		return this.classes;
	}

	public void setClasses(Set<Classe> classes) {
		this.classes = classes;
	}

}
