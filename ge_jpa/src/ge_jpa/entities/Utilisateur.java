// default package
// Generated 18 nov. 2015 14:37:33 by Hibernate Tools 4.3.1.Final
//author : Alexandre Brosse

package ge_jpa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Utilisateur generated by hbm2java
 */
@Entity
@Table(name = "utilisateur", catalog = "sql496886")
public class Utilisateur implements java.io.Serializable {

	private Integer utiId;
	private Role role;
	private String utiLogin;
	private String utiPass;
	private String utiMail;

	public Utilisateur() {
	}

	public Utilisateur(Role role) {
		this.role = role;
	}

	public Utilisateur(Role role, String utiLogin, String utiPass, String utiMail) {
		this.role = role;
		this.utiLogin = utiLogin;
		this.utiPass = utiPass;
		this.utiMail = utiMail;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "UTI_ID", unique = true, nullable = false)
	public Integer getUtiId() {
		return this.utiId;
	}

	public void setUtiId(Integer utiId) {
		this.utiId = utiId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ROL_ID", nullable = false)
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(name = "UTI_Login", length = 45)
	public String getUtiLogin() {
		return this.utiLogin;
	}

	public void setUtiLogin(String utiLogin) {
		this.utiLogin = utiLogin;
	}

	@Column(name = "UTI_Pass", length = 45)
	public String getUtiPass() {
		return this.utiPass;
	}

	public void setUtiPass(String utiPass) {
		this.utiPass = utiPass;
	}

	@Column(name = "UTI_Mail", length = 45)
	public String getUtiMail() {
		return this.utiMail;
	}

	public void setUtiMail(String utiMail) {
		this.utiMail = utiMail;
	}

}
