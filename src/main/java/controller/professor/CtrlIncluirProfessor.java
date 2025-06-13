package controller.professor;

import controller.ICtrl;
import model.Departamento;
import model.Professor;
import model.dao.DaoProfessor;

public class CtrlIncluirProfessor extends CtrlAbstratoProfessor {
	
	// METODOS
	public CtrlIncluirProfessor(ICtrl c) {
				super(c, "Incluir Professor", false);
				this.professorCriado = null;
				this.meuViewer.apresentar();
			}

	@Override
	public void efetuar(int idProfessor, String nome, String endereco, String telefone, String cpf, String especialidade, Departamento idDepartamento) {
		try {
			this.professorCriado = new Professor(idProfessor,nome,endereco,telefone,cpf,especialidade,idDepartamento);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoProfessor dao = new DaoProfessor();
		dao.incluir(professorCriado);
		this.finalizar();
	}

	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}

	public Object getBemTangivel() {
		return this.professorCriado;
		}
}
