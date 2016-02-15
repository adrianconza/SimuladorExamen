package ec.com.simuladorexamen.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(schema = "\"simuladorExamen\"", name = "parametros")
public class Parametro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "PARAMETROS_ID_GENERATOR", sequenceName = "PARAMETROS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PARAMETROS_ID_GENERATOR")
	@Column(unique = true, nullable = false)
	private Integer id;

	@Column(name = "\"mailSmtpHost\"", length = 25, nullable = false)
	private String mailSmtpHost;

	@Column(name = "\"mailSmtpPort\"", length = 25, nullable = false)
	private String mailSmtpPort;

	@Column(name = "\"mailSmtpAuth\"", length = 25, nullable = false)
	private Boolean mailSmtpAuth;

	@Column(name = "\"mailSmtpSslTrust\"", nullable = false)
	private String mailSmtpSslTrust;

	@Column(name = "\"mailSmtpStartTlsEnable\"", nullable = false)
	private Boolean mailSmtpStartTlsEnable;

	@Column(name = "\"emailEmisor\"", length = 25, nullable = false)
	private String emailEmisor;

	@Column(name = "\"passEmail\"", length = 25, nullable = false)
	private String passEmail;

	public Parametro() {
	}

	public String getEmailEmisor() {
		return emailEmisor;
	}

	public Integer getId() {
		return id;
	}

	public Boolean getMailSmtpAuth() {
		return mailSmtpAuth;
	}

	public String getMailSmtpHost() {
		return mailSmtpHost;
	}

	public String getMailSmtpPort() {
		return mailSmtpPort;
	}

	public String getMailSmtpSslTrust() {
		return mailSmtpSslTrust;
	}

	public Boolean getMailSmtpStartTlsEnable() {
		return mailSmtpStartTlsEnable;
	}

	public String getPassEmail() {
		return passEmail;
	}

	public void setEmailEmisor(String emailEmisor) {
		this.emailEmisor = emailEmisor;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMailSmtpAuth(Boolean mailSmtpAuth) {
		this.mailSmtpAuth = mailSmtpAuth;
	}

	public void setMailSmtpHost(String mailSmtpHost) {
		this.mailSmtpHost = mailSmtpHost;
	}

	public void setMailSmtpPort(String mailSmtpPort) {
		this.mailSmtpPort = mailSmtpPort;
	}

	public void setMailSmtpSslTrust(String mailSmtpSslTrust) {
		this.mailSmtpSslTrust = mailSmtpSslTrust;
	}

	public void setMailSmtpStartTlsEnable(Boolean mailSmtpStartTlsEnable) {
		this.mailSmtpStartTlsEnable = mailSmtpStartTlsEnable;
	}

	public void setPassEmail(String passEmail) {
		this.passEmail = passEmail;
	}

}