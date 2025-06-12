package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Departamento {
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idDepartamento;
	@Column 
	private String nome;
	
	
	// METODOS
	public Departamento(int idDepartamento, String nome) {
		super();
		this.idDepartamento = idDepartamento;
		this.nome = nome;
	}


	public int getIdDepartamento() {
		return idDepartamento;
	}


	public void setIdDepartamento(int idDepartamento) {
		this.idDepartamento = idDepartamento;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
