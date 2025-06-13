package controller.disciplina;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Disciplina;
import model.dao.DaoDisciplina;
import viewer.disciplina.JanelaIncluirDisciplina;

abstract public class CtrlAbstratoDisciplina extends CtrlAbstrato {

	// ATRIBUTOS
	protected JanelaIncluirDisciplina meuViewer;
	protected Disciplina disciplinaCriada;
	final protected String operacao;

	// METODOS
	public CtrlAbstratoDisciplina(ICtrl c, String operacao, boolean habilitarProcura) {
		super(c);
		this.disciplinaCriada = null;
		this.operacao = operacao;
		this.meuViewer = new JanelaIncluirDisciplina(this, habilitarProcura);
	}

	public String getOperacao() {
		return this.operacao;
	}

	public void procurarDisciplinaPorId(int idDisciplina) {
		DaoDisciplina dao = new DaoDisciplina();
		this.disciplinaCriada = dao.consultarDisciplinaPorID(idDisciplina);

		if (this.disciplinaCriada == null) {
			this.meuViewer.notificar("Disciplina NAO encontrado com id informado");
		}
	}

	abstract public void efetuar(int idDisciplina, String nome, int credito);

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.disciplinaCriada;
	}
}
