package controller.realiza;

import java.util.Set;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Aluno;
import model.Cursa;
import model.Prova;
import model.Realiza;
import model.Turma;
import model.dao.DaoRealiza;
import viewer.realiza.JanelaIncluirRealiza;

abstract public class CtrlAbstratoRealiza extends CtrlAbstrato {

	// ATRIBUTOS
	protected JanelaIncluirRealiza meuViewer;
	protected Realiza realizaCriado;
	final protected String operacao;

	// METODOS
	public CtrlAbstratoRealiza(ICtrl c, String operacao, boolean habilitarProcura) {
				super(c);
				this.realizaCriado = null;
				this.operacao = operacao;
				this.meuViewer = new JanelaIncluirRealiza(this, habilitarProcura);
			}

	public String getOperacao() {
		return this.operacao;
	}

	public void consultarRealizaPorID(int idRealiza) {
		DaoRealiza dao = new DaoRealiza();
		this.realizaCriado = dao.consultarRealizaPorID(idRealiza);

		if (this.realizaCriado == null) {
			this.meuViewer.notificar("Realiza NAO encontrado com id informado");
		}
	}

	abstract public void efetuar(int idRealiza, double nota, Set<Cursa> conjIdCursa, Set<Prova> conjIdProva);

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.realizaCriado;
	}
}
