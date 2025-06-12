package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import model.validacao.ValidarDisciplina;

@Entity
public class Disciplina {
	
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idDisciplina;
	@Column(length=MAX_QTD_CARACTERES)
	private String nome;
	@Column
	private float credito;
	
	
	
	public Disciplina(int idDisciplina, String nome, float credito) throws Exception {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.credito = credito;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) throws Exception {
		ValidarDisciplina.validarIdDisciplina(idDisciplina);
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		ValidarDisciplina.validarNome(nome);
		this.nome = nome;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) throws Exception {
		ValidarDisciplina.validarCredito(credito);
		this.credito = credito;
	}
	
	
}
