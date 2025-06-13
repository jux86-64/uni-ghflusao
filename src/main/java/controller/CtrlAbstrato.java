package controller;

import viewer.JanelaPrincipal;

abstract public class CtrlAbstrato implements ICtrl {
	
	final private ICtrl     ctrlPai;
	private StatusExecucao  status;
	protected JanelaPrincipal meuViewer;
	
	public CtrlAbstrato(ICtrl c) {
		this.ctrlPai = c;
		this.status = StatusExecucao.EM_EXECUCAO;
	}

	@Override
	public ICtrl getCtrlPai() {
		return this.ctrlPai;
	}

	@Override
	public StatusExecucao getStatus() {
		return this.status;
	}
	
	@Override
	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
	}
	
	public void setStatus(StatusExecucao status) {
		this.status = status;
	}
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
}