package br.com.sdvweb.backend.dto;

import org.springframework.beans.BeanUtils;

import br.com.sdvweb.backend.entity.User;

public class UserDTO {

	private Long id;
	private String nome;
	private String email;
	private String senha;
	private String role;

	public UserDTO(User user) {
		BeanUtils.copyProperties(user, this);
	}

	public UserDTO() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
