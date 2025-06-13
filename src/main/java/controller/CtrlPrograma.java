package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import controller.aluno.CtrlIncluirAluno;
import controller.departamento.CtrlIncluirDepartamento;
import controller.disciplina.CtrlIncluirDisciplina;
import controller.professor.CtrlIncluirProfessor;
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
	
	// ATRIBUTOS CONEXÃO COM HSQLDB
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("uni-ghflusao");
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
	
	public static void main(String[] args) {
		new CtrlPrograma();
	}
}
