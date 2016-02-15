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
@Table(schema = "\"simuladorExamen\"", name = "usuarios")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(allocationSize = 1, name = "USUARIOS_ID_GENERATOR", sequenceName = "USUARIOS_ID_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARIOS_ID_GENERATOR")
	@Column(unique = true, nullable = false, length = 15)
	private Integer id;

	@Column(unique = true, nullable = false, length = 50)
	private String email;

	@Column(length = 64)
	private String password;

	@Column(length = 4)
	private String rol;

	public Usuario() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}