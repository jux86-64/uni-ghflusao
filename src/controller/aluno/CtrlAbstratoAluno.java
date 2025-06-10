package controller.aluno;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Aluno;
import model.Turma;
import model.dao.DaoAluno;
import viewer.aluno.JanelaAluno;

abstract public class CtrlAbstratoAluno extends CtrlAbstrato {
	
	// ATRIBUTOS
	protected JanelaAluno meuViewer;
	protected Aluno alunoSelecionado;
	final protected String operacao;
	
	// METODOS
	public CtrlAbstratoAluno(ICtrl c, String operacao, boolean habilitarProcura) {
		super(c);
		this.alunoSelecionado = null;
		this.operacao = operacao;
		this.meuViewer = new JanelaAluno(this, habilitarProcura);
	}
	
	public String getOperacao() {
		return this.operacao;
	}
	
	public void procurarAlunoPorMatricula(int matricula) {
		DaoAluno dao = new DaoAluno();
		this.alunoSelecionado = dao.consultarPorMatricula(matricula);
		
		if(this.alunoSelecionado == null) {
			this.meuViewer.notificar("Aluno NAO encontrado com matriicula informada");
		}
		
		this.meuViewer.atualizarDados(this.alunoSelecionado.getIdAluno(),
									  this.alunoSelecionado.getMatricula(),
									  this.alunoSelecionado.getCpf(),
									  this.alunoSelecionado.getTelefone(),
									  this.alunoSelecionado.getEndereco(),
									  this.alunoSelecionado.getIdade(),
									  this.alunoSelecionado.getNome(),
									  this.alunoSelecionado.getIdTurma());
	}
	
	abstract public void efetuar(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Turma idTurma);
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.alunoSelecionado;
	}
}
