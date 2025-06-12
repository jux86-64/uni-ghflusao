package model;


import javax.persistence.*;

import model.validacao.ValidarTurma;


public class Turma {
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS 
	private int idTurma;
	private Turno turno;
	private Situacao situacao;
	private String data_t;
	private int idProfessor;
	
	
	// ATRIBUTOS DE RELACIONAMENTO
	@OneToMany(mappedBy="idDisciplina")
	private Disciplina idDisciplina;
	
	public Turma(int idTurma, Turno turno, Situacao situacao, String data_t, Disciplina idDisciplina, int idProfessor) {
		super();
		this.idTurma = idTurma;
		this.turno = turno;
		this.situacao = situacao;
		this.data_t = data_t;
		this.idDisciplina = idDisciplina;
		this.idProfessor = idProfessor;
	}

	public int getIdTurma() {
		return idTurma;
	}

	public void setIdTurma(int idTurma) throws Exception {
		ValidarTurma.validarIdTurma(idTurma);
		this.idTurma = idTurma;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) throws Exception {
		ValidarTurma.validarTurno(turno);
		this.turno = turno;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) throws Exception {
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

	public Disciplina getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Disciplina idDisciplina) throws Exception {
		ValidarTurma.validarIdDisciplina(idDisciplina);
		this.idDisciplina = idDisciplina;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) throws Exception {
		ValidarTurma.validarIdProfessor(idProfessor);
		this.idProfessor = idProfessor;
	}

	@Override
    public String toString() {
        return "toString de turma :)";
    }
	
}
