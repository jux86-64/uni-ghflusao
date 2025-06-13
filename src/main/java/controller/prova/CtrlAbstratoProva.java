package controller.prova;

import java.util.Set;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Aluno;
import model.Prova;
import model.Turma;
import model.dao.DaoProva;
import viewer.prova.JanelaIncluirProva;

abstract public class CtrlAbstratoProva extends CtrlAbstrato {

	// ATRIBUTOS
	protected JanelaIncluirProva meuViewer;
	protected Prova provaCriada;
	final protected String operacao;

	// METODOS
	public CtrlAbstratoProva(ICtrl c, String operacao, boolean habilitarProcura) {
				super(c);
				this.provaCriada = null;
				this.operacao = operacao;
				this.meuViewer = new JanelaIncluirProva(this, habilitarProcura);
			}

	public String getOperacao() {
		return this.operacao;
	}

	public void consultarProvaPorID(int idProva) {
		DaoProva dao = new DaoProva();
		this.provaCriada = dao.consultarProvaPorID(idProva);

		if (this.provaCriada == null) {
			this.meuViewer.notificar("Prova NAO encontrado com id informado");
		}
	}

	abstract public void efetuar(int idProva, String data_p, double peso, Set<Turma> conjIdTurma);

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.provaCriada;
	}
}
