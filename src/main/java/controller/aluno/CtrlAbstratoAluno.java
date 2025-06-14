package controller.aluno;

import java.util.Set;

import controller.CtrlAbstrato;
import controller.ICtrl;
import controller.StatusExecucao;
import model.Aluno;
import model.Turma;
import model.dao.DaoAluno;
import viewer.aluno.JanelaIncluirAluno;

abstract public class CtrlAbstratoAluno extends CtrlAbstrato {
	
	// ATRIBUTOS
	protected JanelaIncluirAluno meuViewer;
	protected Aluno alunoCriado;
	final protected String operacao;
	private StatusExecucao  status;
	
	// METODOS
	public CtrlAbstratoAluno(ICtrl c, String operacao, boolean habilitarProcura) {
		super(c);
		this.alunoCriado = null;
		this.operacao = operacao;
		this.meuViewer = new JanelaIncluirAluno(this, habilitarProcura);
		this.status = StatusExecucao.EM_EXECUCAO;
	}
	
	public String getOperacao() {
		return this.operacao;
	}
	
	public void procurarAlunoPorMatricula(int matricula) {
		DaoAluno dao = new DaoAluno();
		this.alunoCriado = dao.consultarAlunoPorMatricula(matricula);
		
		if(this.alunoCriado == null) {
			this.meuViewer.notificar("Aluno NAO encontrado com matricula informada");
		}
	}
	
	abstract public void efetuar(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Set<Turma> idTurma);
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.alunoCriado;
	}
} 
