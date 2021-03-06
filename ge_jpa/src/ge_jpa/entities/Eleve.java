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
 * Eleve generated by hbm2java
 */
@Entity
@Table(name = "eleve", catalog = "sql496886")
public class Eleve implements java.io.Serializable {

	private Integer elvId;
	private Classe classe;
	private String elvNom;
	private String elvPrenom;
	private String elvSexe;
	private String elvDateNaissance;
	private Set<FraisInscription> fraisInscriptions = new HashSet<FraisInscription>(0);
	private Set<Responsable> responsables = new HashSet<Responsable>(0);

	public Eleve() {
		this.classe =new Classe();
	}

	public Eleve(Classe classe) {
		this.classe = classe;
	}

	public Eleve(Classe classe, String elvNom, String elvPrenom, String elvSexe,
			String elvDateNaissance, Set<FraisInscription> fraisInscriptions, Set<Responsable> responsables) {
		this.classe = classe;
		this.elvNom = elvNom;
		this.elvPrenom = elvPrenom;
		this.elvSexe = elvSexe;
		this.elvDateNaissance = elvDateNaissance;
		this.fraisInscriptions = fraisInscriptions;
		this.responsables = responsables;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "ELV_ID", unique = true, nullable = false)
	public Integer getElvId() {
		return this.elvId;
	}

	public void setElvId(Integer elvId) {
		this.elvId = elvId;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "CLA_ID", nullable = false)
	public Classe getClasse() {
		return this.classe;
	}

	public void setClasse(Classe classe) {
		this.classe = classe;
	}

	@Column(name = "ELV_Nom", length = 45)
	public String getElvNom() {
		return this.elvNom;
	}

	public void setElvNom(String elvNom) {
		this.elvNom = elvNom;
	}

	@Column(name = "ELV_Prenom", length = 45)
	public String getElvPrenom() {
		return this.elvPrenom;
	}

	public void setElvPrenom(String elvPrenom) {
		this.elvPrenom = elvPrenom;
	}

	@Column(name = "ELV_Sexe", length = 45)
	public String getElvSexe() {
		return this.elvSexe;
	}

	public void setElvSexe(String elvSexe) {
		this.elvSexe = elvSexe;
	}

	@Column(name = "ELV_Date_Naissance", length = 45)
	public String getElvDateNaissance() {
		return this.elvDateNaissance;
	}

	public void setElvDateNaissance(String elvDateNaissance) {
		this.elvDateNaissance = elvDateNaissance;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "eleve")
	public Set<FraisInscription> getFraisInscriptions() {
		return this.fraisInscriptions;
	}

	public void setFraisInscriptions(Set<FraisInscription> fraisInscriptions) {
		this.fraisInscriptions = fraisInscriptions;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "eleve")
	public Set<Responsable> getResponsables() {
		return this.responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}
	

}
