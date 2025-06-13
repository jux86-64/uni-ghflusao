package controller.departamento;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Departamento;
import model.dao.DaoDepartamento;
import viewer.departamento.JanelaIncluirDepartamento;

abstract public class CtrlAbstratoDepartamento extends CtrlAbstrato {
	
	// ATRIBUTOS
	protected JanelaIncluirDepartamento meuViewer;
	protected Departamento departamentoCriado;
	final protected String operacao;

	// METODOS
	public CtrlAbstratoDepartamento(ICtrl c, String operacao, boolean habilitarProcura) {
			super(c);
			this.departamentoCriado = null;
			this.operacao = operacao;
			this.meuViewer = new JanelaIncluirDepartamento(this, habilitarProcura);
		}

	public String getOperacao() {
		return this.operacao;
	}

	public void consultarDepartamentoPorID(int idDepartamento) {
		DaoDepartamento dao = new DaoDepartamento();
		this.departamentoCriado = dao.consultarDepartamentoPorID(idDepartamento);

		if (this.departamentoCriado == null) {
			this.meuViewer.notificar("Departamento NAO encontrado com id informado");
		}
	}

	abstract public void efetuar(int idDepartamento, String nome);

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.departamentoCriado;
	}
}
