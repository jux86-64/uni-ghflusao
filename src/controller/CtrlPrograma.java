package controller;

import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {
	private JanelaPrincipal janela;
	
	public void finalizar() {
		this.janela.notificar("Encerrando o programa!");
		this.janela.finalizar();
		System.exit(0);
	}
}
