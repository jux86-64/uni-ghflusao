package model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import model.validacao.ValidarProfessor;

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
	private int idade;
	@Column
	private String especialidade;
	
	
	// ATRIBUTO DE RELACIONAMENTO
	@OneToMany(mappedBy="idDepartamento")
	private Set<Departamento> conjIdDepartamento;
	
	
	// METODOS
	public Professor() {
		System.out.println("Construtor de Professor com assinatura vazia foi chamado");
	}
	
	public Professor(int idProfessor, String nome, String endereco, String telefone, String cpf, int idade, String especialidade, Departamento idDepartamento) throws Exception {
		super();
		this.idProfessor = idProfessor;
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.cpf = cpf;
		this.idade = idade;
		this.especialidade = especialidade;
		this.setConjIdDepartamento(new HashSet<Departamento>());
	}

	
	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) throws Exception{
		ValidarProfessor.validarIdProfessor(idProfessor);
		this.idProfessor = idProfessor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		ValidarProfessor.validarNome(nome);
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) throws Exception {
		ValidarProfessor.validarEndereco(endereco);
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) throws Exception {
		ValidarProfessor.validarTelefone(telefone);
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) throws Exception {
		ValidarProfessor.validarCpf(cpf);
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) throws Exception {
		ValidarProfessor.validarIdade(idade);
		this.idade = idade;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) throws Exception {
		ValidarProfessor.validarEspecialidade(especialidade);
		this.especialidade = especialidade;
	}

	public Set<Departamento> getConjIdDepartamento() {
		return conjIdDepartamento;
	}

	public void setConjIdDepartamento(Set<Departamento> conjIdDepartamento) throws Exception {
		ValidarProfessor.validarConjIdDepartamento(conjIdDepartamento);
		this.conjIdDepartamento = conjIdDepartamento;
	}
	
}
