package controller.disciplina;

import controller.ICtrl;
import model.Disciplina;
import model.Professor;
import model.Disciplina;
import model.dao.DaoDisciplina;
import model.enumerado.Situacao;
import model.enumerado.Turno;

public class CtrlIncluirDisciplina extends CtrlAbstratoDisciplina {
	
	// METODOS
	public CtrlIncluirDisciplina(ICtrl c) {
			super(c, "Incluir Disciplina", false);
			this.disciplinaCriada = null;
			this.meuViewer.apresentar();
		}

	@Override
	public void efetuar(int idDisciplina, String nome, int credito) {
		try {
			this.disciplinaCriada = new Disciplina(idDisciplina,nome,credito);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoDisciplina dao = new DaoDisciplina();
		dao.incluir(disciplinaCriada);
		this.finalizar();
	}

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.disciplinaCriada;
	}

}
