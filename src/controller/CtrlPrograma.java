package controller;

import controller.aluno.CtrlIncluirAluno;
import viewer.JanelaPrincipal;

public class CtrlPrograma extends CtrlAbstrato {
	
	// ATRIBUTOS DE RELACIONAMENTO
	private JanelaPrincipal janela;
	private CtrlIncluirAluno ctrlIncluirAluno;
	
	
	// METODOS
	public CtrlPrograma() {
		super(null);
		this.janela = new JanelaPrincipal(this);
		this.ctrlIncluirAluno = null;
	}

	public void iniciarIncluirAluno() {
		if (this.ctrlIncluirAluno == null)
			this.ctrlIncluirAluno = new CtrlIncluirAluno(this);
		else 
			this.janela.notificar("Você já iniciou a funcionalidade de Incluir Aluno");
	}
	
	
	@Override
	public void ctrlFilhoFinalizado(ICtrl ctrlFilho) {
		if (ctrlFilho instanceof CtrlIncluirAluno)
			this.ctrlIncluirAluno = null;
	}
	
	
	public void finalizar() {
		this.janela.notificar("Encerrando o programa!");
		this.janela.finalizar();
		System.exit(0);
	}
	
	public Object getBemTangivel() {
		return null;
	}
	
	public static void main(String[] args) {
		new CtrlPrograma();
	}
}
