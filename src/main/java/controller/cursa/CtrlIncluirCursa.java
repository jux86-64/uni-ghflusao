package controller.cursa;

import java.util.Set;

import controller.ICtrl;
import model.Aluno;
import model.Cursa;
import model.Turma;
import model.dao.DaoCursa;

public class CtrlIncluirCursa extends CtrlAbstratoCursa {
	// METODOS
	public CtrlIncluirCursa(ICtrl c) {
				super(c, "Incluir Cursa", false);
				this.cursaCriado = null;
				this.meuViewer.apresentar();
			}

	@Override
	public void efetuar(int idCursa, String data_c, Set<Aluno> aluno, Set<Turma> turma) {
		try {
			this.cursaCriado = new Cursa(idCursa,data_c,aluno,turma);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoCursa dao = new DaoCursa();
		dao.incluir(cursaCriado);
		this.finalizar();
	}

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.cursaCriado;
	}
}