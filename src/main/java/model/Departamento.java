package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import model.validacao.ValidarDepartamento;

@Entity
public class Departamento {
	
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idDepartamento;
	@Column(length=MAX_QTD_CARACTERES) 
	private String nome;
	
	
	// METODOS
	public Departamento(int idDepartamento, String nome) throws Exception {
		super();
		this.idDepartamento = idDepartamento;
		this.nome = nome;
	}


	public int getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(int idDepartamento) throws Exception {
		ValidarDepartamento.validarNome(nome);
		this.idDepartamento = idDepartamento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) throws Exception {
		ValidarDepartamento.validarNome(nome);
		this.nome = nome;
	}
	
	
}
