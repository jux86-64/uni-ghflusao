package controller.prova;

import java.util.Set;

import controller.ICtrl;
import model.Aluno;
import model.Cursa;
import model.Prova;
import model.Prova;
import model.Turma;
import model.dao.DaoProva;

public class CtrlIncluirProva extends CtrlAbstratoProva {
	// METODOS
	public CtrlIncluirProva(ICtrl c) {
		super(c, "Incluir Prova", false);
		this.provaCriada = null;
		this.meuViewer.apresentar();
	}

	@Override
	public void efetuar(int idProva, String data_p, double peso, Set<Turma> conjIdTurma) {
		try {
			this.provaCriada = new Prova(idProva,data_p,peso,conjIdTurma);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoProva dao = new DaoProva();
		dao.incluir(provaCriada);
		this.finalizar();
	}

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.provaCriada;
	}
}