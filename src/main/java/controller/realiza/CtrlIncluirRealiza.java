package controller.realiza;

import java.util.Set;

import controller.ICtrl;
import model.Aluno;
import model.Cursa;
import model.Prova;
import model.Realiza;
import model.Turma;
import model.dao.DaoRealiza;

public class CtrlIncluirRealiza extends CtrlAbstratoRealiza {
	// METODOS
	public CtrlIncluirRealiza(ICtrl c) {
		super(c, "Incluir Realiza", false);
		this.realizaCriado = null;
		this.meuViewer.apresentar();
	}

	@Override
	public void efetuar(int idRealiza, double nota, Set<Cursa> conjIdCursa, Set<Prova> conjIdProva) {
		try {
			this.realizaCriado = new Realiza(idRealiza, nota, conjIdCursa, conjIdProva);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoRealiza dao = new DaoRealiza();
		dao.incluir(realizaCriado);
		this.finalizar();
	}

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.realizaCriado;
	}
}