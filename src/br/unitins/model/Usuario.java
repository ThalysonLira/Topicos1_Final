package br.unitins.model;

import java.time.LocalDate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.br.CPF;

public class Usuario {
	
	private Integer id;
	
	@NotBlank(message="O nome deve ser informado.")
	private String nome;
	
	@CPF(message="Formato do cpf incorreto.")
	private String cpf;
	private LocalDate dataNascimento;
	
	@Email(message="Email inválido.")
	@NotBlank(message="O email deve ser informado.")
	private String login;
	
	@Size(min=8, message="Tamanho incompatível, mínimo de 8 caracteres.")
	@Size(max=20, message="Tamanho incompatível, máximo de 25 caracteres.")
	private String senha;
	private Perfil perfil;
	
	public Usuario() {
		// TODO Auto-generated constructor stub
	}
	
	public Usuario(Integer id, String nome, String cpf, String login, String senha, Perfil perfil) {
		this.id = id;
		this.nome = nome;
		this.login = login;
		this.senha = senha;
		this.perfil = perfil;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Perfil getPerfil() {
		return perfil;
	}

	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
	}
}
