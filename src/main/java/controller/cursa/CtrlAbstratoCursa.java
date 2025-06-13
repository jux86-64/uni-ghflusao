package controller.cursa;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Aluno;
import model.Cursa;
import model.Turma;
import model.dao.DaoCursa;
import viewer.cursa.JanelaIncluirCursa;

abstract public class CtrlAbstratoCursa extends CtrlAbstrato {

	// ATRIBUTOS
	protected JanelaIncluirCursa meuViewer;
	protected Cursa cursaCriado;
	final protected String operacao;

	// METODOS
	public CtrlAbstratoCursa(ICtrl c, String operacao, boolean habilitarProcura) {
				super(c);
				this.cursaCriado = null;
				this.operacao = operacao;
				this.meuViewer = new JanelaIncluirCursa(this, habilitarProcura);
			}

	public String getOperacao() {
		return this.operacao;
	}

	public void consultarCursaPorID(int idCursa) {
		DaoCursa dao = new DaoCursa();
		this.cursaCriado = dao.consultarCursaPorID(idCursa);

		if (this.cursaCriado == null) {
			this.meuViewer.notificar("Cursa NAO encontrado com id informado");
		}
	}

	abstract public void efetuar(int idCursa, String data_c, Aluno idAluno, Turma idTurma);

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.cursaCriado;
	}
}
