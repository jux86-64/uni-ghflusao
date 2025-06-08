import jakarta.persistence.*;


public class Turma {
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS 
	private int idTurma;
	private String turno;
	// situacao pode ser um enum
	private String situacao;
	private String data_t;
	private int idProfessor;
	
	
	// ATRIBUTOS DE RELACIONAMENTO
	@OneToMany(mappedBy="idDisciplina")
	private Disciplina idDisciplina;
	
	public Turma(int idTurma, String turno, String situacao, String data_t, Disciplina idDisciplina, int idProfessor) {
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
		this.idTurma = idTurma;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) throws Exception {
		this.turno = turno;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) throws Exception {
		this.situacao = situacao;
	}

	public String getData_t() {
		return data_t;
	}

	public void setData_t(String data_t) throws Exception {
		this.data_t = data_t;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(Disciplina idDisciplina) throws Exception {
		this.idDisciplina = idDisciplina;
	}

	public int getIdProfessor() {
		return idProfessor;
	}

	public void setIdProfessor(int idProfessor) throws Exception {
		this.idProfessor = idProfessor;
	}
	
	
}
