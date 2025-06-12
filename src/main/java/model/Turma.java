package model;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import model.validacao.ValidarTurma;

@Entity
public class Turma {
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS 
	@Id @GeneratedValue
	private int idTurma;
	@Column
	private Turno turno;
	@Column
	private Situacao situacao;
	@Column
	private String data_t;
	
	
	// ATRIBUTOS DE RELACIONAMENTO
	@OneToMany(mappedBy="idDisciplina")
	private Set<Disciplina> conjIdDisciplina;
	@OneToMany(mappedBy="idProfessor")
	private Set<Professor> conjIdProfessor;
	
	public Turma(int idTurma, Turno turno, Situacao situacao, String data_t) throws Exception {
		super();
		this.idTurma = idTurma;
		this.turno = turno;
		this.situacao = situacao;
		this.data_t = data_t;
		this.setConjIdDisciplina(new HashSet<Disciplina>());
		this.setConjIdProfessor(new HashSet<Professor>());
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) throws Exception {
		ValidarTurma.validarIdTurma(idTurma);
		this.idTurma = idTurma;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) throws Exception {
		ValidarTurma.validarTurno(turno);
		this.turno = turno;
	}

	public Situacao getSituacao() {
		return situacao;
	}

	public void setSituacao(Situacao situacao) throws Exception {
		ValidarTurma.validarSituacao(situacao);
		this.situacao = situacao;
	}

	public String getData_t() {
		return data_t;
	}

	public void setData_t(String data_t) throws Exception {
		ValidarTurma.validarData(data_t);
		this.data_t = data_t;
	}

	public void setConjIdDisciplina(Set<Disciplina> conjIdDisciplina) throws Exception {
		ValidarTurma.validarConjIdDisciplina(conjIdDisciplina);
		this.conjIdDisciplina = conjIdDisciplina;
	}

	public void setConjIdProfessor(Set<Professor> conjIdProfessor) throws Exception {
		ValidarTurma.validarConjIdProfessor(conjIdProfessor);
		this.conjIdProfessor = conjIdProfessor;
	}

	@Override
    public String toString() {
        return "toString de turma :)";
    }
	
}
