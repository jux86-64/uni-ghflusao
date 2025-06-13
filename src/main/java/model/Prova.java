package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import model.validacao.ValidarProva;

@Entity
public class Prova {

	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idProva;
	@Column
	private String data_p;
	@Column
	private double peso;
	
	// ATRIBUTOS DE RELACIONAMENTO
	@OneToMany(mappedBy="idTurma")
	private Set<Turma> conjIdTurma;

	
	// METODOS
	public Prova(int idProva, String data_p, double peso, Set<Turma> conjIdTurma) throws Exception {
		super();
		this.idProva = idProva;
		this.data_p = data_p;
		this.peso = peso;
		this.conjIdTurma = conjIdTurma;
	}


	public int getIdProva() {
		return idProva;
	}


	public void setIdProva(int idProva) throws Exception {
		ValidarProva.validarIdProva(idProva);
		this.idProva = idProva;
	}


	public String getData_p() {
		return data_p;
	}


	public void setData_p(String data_p) throws Exception {
		ValidarProva.validarData(data_p);
		this.data_p = data_p;
	}


	public double getPeso() {
		return peso;
	}


	public void setPeso(double peso) throws Exception {
		ValidarProva.validarPeso(peso);
		this.peso = peso;
	}


	public Set<Turma> getConjIdTurma() {
		return conjIdTurma;
	}


	public void setConjIdTurma(Set<Turma> conjIdTurma) throws Exception {
		ValidarProva.validarConjIdTurma(conjIdTurma);
		this.conjIdTurma = conjIdTurma;
	}
	
	
	
}
