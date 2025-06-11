package controller.aluno;



import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import model.dao.DaoTurma;
import viewer.aluno.JanelaAluno;
import model.Aluno;
import model.Turma;

public class CtrlIncluirAluno extends CtrlAbstrato {
	
	// ATRIBUTOS
	private JanelaAluno janela;
	private Aluno alunoCriado;
	
	private CtrlIncluirTurma ctrlIncluirTurma;
	private Turma idTurma;
	
	
	// METODOS 
	public CtrlIncluirAluno(CtrlPrograma c) {
		super(c);
		this.ctrlIncluirTurma = null;
		this.alunoCriado = null;
		DaoTurma daoTurma = new DaoTurma();
		
		
	}
}
