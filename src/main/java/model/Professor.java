package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Professor {
	
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idProfessor;
	@Column
	private String nome;
	@Column
	private String endereco;
	@Column
	private String telefone;
	@Column
	private String cpf;
	@Column
	private String especialidade;
	
	// ATRIBUTO DE RELACIONAMENTO
	@OneToMany(mappedBy="idDepartamento")
	private Set<Departamento> conjIdDepartamento;
	
	
	// METODOS
	public Professor() {
		System.out.println("Construtor de Professor com assinatura vazia foi chamado");
	}
	
	public Professor(int idProfessor, String nome, String endereco, String telefone, String cpf, String especialidade) throws Exception {
		super();
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.especialidade = especialidade;
		this.setConjIdDepartamento(new HashSet<Departamento>());
	}

	
	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) {
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Set<Departamento> getConjIdDepartamento() {
		return conjIdDepartamento;
	}

	public void setConjIdDepartamento(Set<Departamento> conjIdDepartamento) {
		this.conjIdDepartamento = conjIdDepartamento;
	}
	
}
