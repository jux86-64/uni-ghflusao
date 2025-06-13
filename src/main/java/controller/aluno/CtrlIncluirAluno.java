package controller.aluno;



import java.util.Set;

import controller.ICtrl;
import model.Aluno;
import model.Turma;
import model.dao.DaoAluno;

public class CtrlIncluirAluno extends CtrlAbstratoAluno {
	
	
	// METODOS 
	public CtrlIncluirAluno(ICtrl c) {
		super(c, "Incluir Aluno", false);
		this.meuViewer.apresentar();
	}


	@Override
	public void efetuar(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade,
			String nome, Set<Turma> idTurma) {
		try {
			this.alunoCriado = new Aluno(idAluno,matricula,cpf,telefone,endereco,idade,
					nome,idTurma);
			DaoAluno daoAluno = new DaoAluno();
			daoAluno.incluir(alunoCriado);
			this.meuViewer.notificar("Aluno Incluido com sucesso");
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}
		this.finalizar();
	}
}
