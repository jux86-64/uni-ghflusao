package controller.aluno;



import controller.CtrlPrograma;
import controller.turma.CtrlIncluirTurma;
import model.Aluno;
import model.Turma;
import model.dao.DaoTurma;
import viewer.aluno.JanelaIncluirAluno;

public class CtrlIncluirAluno extends CtrlAbstratoAluno {
	
	// ATRIBUTOS
	private JanelaIncluirAluno janela;
	private Aluno alunoCriado;
	
	private CtrlIncluirTurma ctrlIncluirTurma;
	private Turma idTurma;
	
	
	// METODOS 
	public CtrlIncluirAluno(CtrlPrograma c) {
		super(c, "Incluir Aluno", false);
		this.ctrlIncluirTurma = null;
		this.alunoCriado = null;
		DaoTurma daoTurma = new DaoTurma();
		
		
	}


	@Override
	public void efetuar(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade,
			String nome, Turma idTurma) {
		// TODO Auto-generated method stub
		
	}
}
