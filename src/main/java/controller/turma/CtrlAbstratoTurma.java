package controller.turma;

import controller.CtrlAbstrato;
import controller.ICtrl;
import model.Disciplina;
import model.Professor;
import model.Turma;
import model.dao.DaoRealiza;
import model.enumerado.Situacao;
import model.enumerado.Turno;
import viewer.turma.JanelaIncluirTurma;

abstract public class CtrlAbstratoTurma extends CtrlAbstrato {
	
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
		DaoRealiza dao = new DaoRealiza();
		this.turmaCriada = dao.consultarTurmaPorID(idTurma);
		
		if(this.turmaCriada == null) {
			this.meuViewer.notificar("Turma NAO encontrado com id informado");
		}
	}
	
	abstract public void efetuar(int idTurma, Turno turno, Situacao situacao, String data_t, Disciplina idDisciplina,
			Professor idProfessor);
	
	public void finalizar() {
		this.meuViewer.finalizar();
		this.getCtrlPai().ctrlFilhoFinalizado(this);
	}
	
	public Object getBemTangivel() {
		return this.turmaCriada;
	}
} 

