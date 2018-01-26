package br.com.estudo.jpa.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Table(name="ffj_user")
@Entity(name="Usuario")
public class Usuario implements Serializable {

	private static final long serialVersionUID = 850039695687057071L;

	@Id
	@SequenceGenerator(name="pk_user", sequenceName="user_id_seq", allocationSize=5000)	
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pk_user")
	@Column(name="id")
	private Long id;
	
	@Column(name="email")
	private String email;
	
	@Column(name="password")
	private char[] password;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="ultimonome")
	private String ultimonome;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char[] getPassword() {
		return password;
	}

	public void setPassword(char[] password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUltimonome() {
		return ultimonome;
	}

	public void setUltimonome(String ultimonome) {
		this.ultimonome = ultimonome;
	}
	
	
	
	
}
