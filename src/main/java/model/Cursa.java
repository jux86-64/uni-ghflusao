package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import model.validacao.ValidarCursa;

@Entity
public class Cursa {
	
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idCursa;
	@Column
	private String data_c;
	
	
	// ATRIBUTOS DE RELACIONAMENTO
	@OneToMany(mappedBy="idAluno")
	private Set<Aluno> conjIdAluno;
	@OneToMany(mappedBy="idTurma")
	private Set<Turma> conjIdTurma;

	
	// METODOS
	public Cursa(int idCursa, String data_c, Set<Aluno> conjIdAluno, Set<Turma> conjIdTurma) throws Exception  {
		super();
		this.idCursa = idCursa;
		this.data_c = data_c;
		this.conjIdAluno = conjIdAluno;
		this.conjIdTurma = conjIdTurma;
	}


	public int getIdCursa() {
		return idCursa;
	}


	public void setIdCursa(int idCursa) throws Exception {
		ValidarCursa.validarIdCursa(idCursa);
		this.idCursa = idCursa;
	}


	public String getData_c() {
		return data_c;
	}


	public void setData_c(String data_c) throws Exception {
		ValidarCursa.validarData(data_c);
		this.data_c = data_c;
	}


	public Set<Aluno> getConjIdAluno() {
		return conjIdAluno;
	}


	public void setConjIdAluno(Set<Aluno> conjIdAluno) throws Exception {
		ValidarCursa.validarConjIdAluno(conjIdAluno);
		this.conjIdAluno = conjIdAluno;
	}


	public Set<Turma> getConjIdTurma() {
		return conjIdTurma;
	}


	public void setConjIdTurma(Set<Turma> conjIdTurma) throws Exception {
		ValidarCursa.validarConjIdTurma(conjIdTurma);
		this.conjIdTurma = conjIdTurma;
	}
}
