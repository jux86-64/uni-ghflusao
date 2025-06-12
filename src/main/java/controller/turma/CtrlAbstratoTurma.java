package controller.turma;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Disciplina;
import model.Situacao;
import model.Turma;
import model.Turno;
import model.dao.DaoTurma;
import viewer.turma.JanelaIncluirTurma;

abstract public class CtrlAbstratoTurma extends CtrlAbstrato{
	
	// ATRIBUTOS
	protected JanelaIncluirTurma meuViewer;
	protected Turma turmaCriada;
	final protected String operacao;
	
	// METODOS
	public CtrlAbstratoTurma(ICtrl c, String operacao, boolean habilitarProcura) {
		super(c);
		this.turmaCriada = null;
		this.operacao = operacao;
		this.meuViewer = new JanelaIncluirTurma(this, habilitarProcura);
	}
	
	public String getOperacao() {
		return this.operacao;
	}
	
	public void procurarTurmaPorId(int idTurma) {
		DaoTurma dao = new DaoTurma();
		this.turmaCriada = dao.consultarTurmaPorID(idTurma);
		
		if(this.turmaCriada == null) {
			this.meuViewer.notificar("Turma NAO encontrado com id informado");
		}
		
		this.meuViewer.atualizarDados(this.turmaCriada.getIdTurma(),
									  this.turmaCriada.getData_t(),
									  this.turmaCriada.getIdDisciplina(),
									  this.turmaCriada.getIdProfessor(),
									  this.turmaCriada.getIdTurma(),
									  this.turmaCriada.getSituacao(),
									  this.turmaCriada.getTurno());
	}
	
	abstract public void efetuar(int idTurma, Turno turno, Situacao situacao, String data_t, Disciplina idDisciplina,
			int idProfessor);
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.turmaCriada;
	}
} 
}
