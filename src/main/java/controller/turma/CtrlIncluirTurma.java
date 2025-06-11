package main.java.controller.turma;



import main.java.controller.CtrlAbstrato;
import main.java.controller.ICtrl;
import main.java.model.Disciplina;
import main.java.model.Turma;
import main.java.model.dao.DaoTurma;
import main.java.viewer.IViewer;

public class CtrlIncluirTurma extends CtrlAbstrato {
	
	// ATRIBUTOS
	private IViewer meuViewer;
	private Turma turmaCriada;
	
	
	// METODOS
	public CtrlIncluirTurma(ICtrl c) {
		super(c);
		this.meuViewer = JanelaTurma(this);
		this.turmaCriada = null;
		this.meuViewer.apresentar();
	}
		
	public void efetuarInclusao(int idTurma, String turno, String situacao, String data_t, Disciplina idDisciplina,
			int idProfessor) {
		try {
			this.turmaCriada = new Turma(idTurma, turno, situacao, data_t, idDisciplina, idProfessor);
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
