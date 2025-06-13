package controller.professor;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Departamento;
import model.Professor;
import model.dao.DaoProfessor;
import viewer.professor.JanelaIncluirProfessor;

abstract public class CtrlAbstratoProfessor extends CtrlAbstrato {

	// ATRIBUTOS
	protected JanelaIncluirProfessor meuViewer;
	protected Professor professorCriado;
	final protected String operacao;

	// METODOS
	public CtrlAbstratoProfessor(ICtrl c, String operacao, boolean habilitarProcura) {
		super(c);
		this.professorCriado = null;
		this.operacao = operacao;
		this.meuViewer = new JanelaIncluirProfessor(this, habilitarProcura);
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void procurarProfessorPorId(int idProfessor) {
		DaoProfessor dao = new DaoProfessor();
		this.professorCriado = dao.consultarProfessorPorID(idProfessor);

		if (this.professorCriado == null) {
			this.meuViewer.notificar("Professor NAO encontrado com id informado");
		}
	}

	abstract public void efetuar(int idProfessor, String nome, String endereco, String telefone, String cpf, int idade,
			String especialidade, Departamento idDepartamento);

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.professorCriado;
	}
}
