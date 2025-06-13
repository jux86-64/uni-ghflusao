package controller.departamento;

import controller.ICtrl;
import model.Departamento;
import model.Disciplina;
import model.dao.DaoDepartamento;
import model.dao.DaoDisciplina;

public class CtrlIncluirDepartamento extends CtrlAbstratoDepartamento {
	// METODOS
	public CtrlIncluirDepartamento(ICtrl c) {
				super(c, "Incluir Disciplina", false);
				this.departamentoCriado = null;
				this.meuViewer.apresentar();
			}

	@Override
	public void efetuar(int idDisciplina, String nome) {
		try {
			this.departamentoCriado = new Departamento(idDisciplina, nome;
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoDepartamento dao = new DaoDepartamento();
		dao.incluir(departamentoCriado);
		this.finalizar();
	}

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.departamentoCriado;
	}
}
