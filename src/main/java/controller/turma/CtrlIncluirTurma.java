package controller.turma;



import controller.ICtrl;
import model.Disciplina;
import model.Professor;
import model.Turma;
import model.dao.DaoTurma;
import model.enumerado.Situacao;
import model.enumerado.Turno;

public class CtrlIncluirTurma extends CtrlAbstratoTurma {

	
	// METODOS
	public CtrlIncluirTurma(ICtrl c) {
		super(c, "Incluir Turma", false);
		this.turmaCriada = null;
		this.meuViewer.apresentar();
	}
	
	@Override
	public void efetuar(int idTurma, Turno turno, Situacao situacao, String data_t, Disciplina idDisciplina,
			Professor idProfessor) {
		try {
			if (idDisciplina == null) {
				this.meuViewer.notificar("Você ainda não definiu o disciplina");
				return;
			}
			
			if (idProfessor == null) {
				this.meuViewer.notificar("Você ainda não definiu o correntista");
				return;
			}
			
			this.turmaCriada = new Turma(idTurma,turno,situacao,data_t,idDisciplina,idProfessor);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}

		DaoTurma dao = new DaoTurma();
		dao.incluir(turmaCriada);
		this.finalizar();
	}
		
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.turmaCriada;
	}
}
