package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Statement;

import controller.aluno.CtrlIncluirAluno;
import controller.cursa.CtrlIncluirCursa;
import controller.departamento.CtrlIncluirDepartamento;
import controller.disciplina.CtrlIncluirDisciplina;
import controller.professor.CtrlIncluirProfessor;
import controller.prova.CtrlIncluirProva;
import controller.realiza.CtrlIncluirRealiza;
import controller.turma.CtrlIncluirTurma;
import viewer.JanelaPrincipal;


public class CtrlPrograma extends CtrlAbstrato {
	
	// ATRIBUTOS DE RELACIONAMENTO
	private JanelaPrincipal meuViewer;
	private CtrlIncluirAluno ctrlIncluirAluno;
	private CtrlIncluirTurma ctrlIncluirTurma;
	private CtrlIncluirDisciplina ctrlIncluirDisciplina;
	private CtrlIncluirProfessor ctrlIncluirProfessor;
	private CtrlIncluirDepartamento ctrlIncluirDepartamento;
	private CtrlIncluirCursa ctrlIncluirCursa;
	private CtrlIncluirProva ctrlIncluirProva;
	private CtrlIncluirRealiza ctrlIncluirRealiza;
	
	
	// ATRIBUTOS CONEXÃO COM HSQLDB
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("unighflusao");
	private static EntityManager        entityManager = entityManagerFactory.createEntityManager();
	
	// METODOS
	public CtrlPrograma() {
		super(null);
		this.meuViewer = new JanelaPrincipal(this);
		this.ctrlIncluirAluno = null;
		this.ctrlIncluirTurma = null;
		this.ctrlIncluirDisciplina = null;
		this.ctrlIncluirProfessor = null;
		this.ctrlIncluirDepartamento = null;
	}
	
	public static EntityManager getEntityManager() { 
		return CtrlPrograma.entityManager; 
	}

	// METODOS DE INCLUSAO
	public void iniciarIncluirAluno() {
		if (this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
		else 
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Aluno");
	}
	
	public void iniciarIncluirTurma() {
		if (this.ctrlIncluirTurma == null)
			this.ctrlIncluirTurma = new CtrlIncluirTurma(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Turma");
	}
	
	public void iniciarIncluirDisciplina() {
		if (this.ctrlIncluirDisciplina == null)
			this.ctrlIncluirDisciplina = new CtrlIncluirDisciplina(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Disciplina");
	}
	
	public void iniciarIncluirProfessor() {
		if (this.ctrlIncluirProfessor == null)
			this.ctrlIncluirProfessor = new CtrlIncluirProfessor(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Professor");
	}
	
	public void iniciarIncluirDepartamento() {
		if (this.ctrlIncluirDepartamento == null)
			this.ctrlIncluirDepartamento = new CtrlIncluirDepartamento(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Departamento");
	}
	
	public void iniciarIncluirCursa() {
		if (this.ctrlIncluirCursa == null)
			this.ctrlIncluirCursa = new CtrlIncluirCursa(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Cursa");
	}
	
	public void iniciarIncluirProva() {
		if (this.ctrlIncluirProva == null)
			this.ctrlIncluirProva = new CtrlIncluirProva(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Prova");
	}
	
	public void iniciarIncluirRealiza() {
		if (this.ctrlIncluirRealiza == null)
			this.ctrlIncluirRealiza = new CtrlIncluirRealiza(this);
		else
			this.meuViewer.notificar("Você já iniciou a funcionalidade de Incluir Realiza");
	}
	
	// METODOS DE ALTERACAO
	
	
	// METODOS DE REMOCAO
	
	
	
	@Override
	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
		if (ctrlFilho instanceof CtrlIncluirAluno)
			this.ctrlIncluirAluno = null;
	}
	
	public void finalizar() {
		this.meuViewer.notificar("Encerrando o programa!");
		this.meuViewer.finalizar();
		System.exit(0);
	}
	
	public Object getBemTangivel() {
		return null;
	}
	
	public static void main(String[] args) throws SQLException {
		// create connection for a server installed in localhost, with a user "root"
		// with no password
		try (Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/", "root", null)) {
			// create a Statement
			try (Statement stmt = conn.createStatement()) {
				// execute query
				try (ResultSet rs = stmt.executeQuery("SELECT 'Hello World!'")) {
					// position result to first
					rs.first();
					System.out.println(rs.getString(1)); // result is "Hello World!"
				}
			}
		}
		new CtrlPrograma();
	}
}
