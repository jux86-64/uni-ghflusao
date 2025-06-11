package controller.aluno;

import controller.ICtrl;
import model.Aluno;
import model.Turma;
import model.dao.DaoAluno;
import viewer.IViewer;

public class CtrlIncluirAluno extends CtrlAbstratoAluno {
	
	// MÉTODOS
	public CtrlIncluirAluno(ICtrl c) {
		super(c, "Incluir Aluno", false); // qq isso mds ---> super(c, "Incluir Livro", false);
		this.meuViewer.apresentar();
	}
	
	
	// MÉTODO DE INCLUSÃO
	public void efetuar(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Turma idTurma) {
		try {
			this.alunoSelecionado = new Aluno(idAluno,matricula,cpf,telefone,endereco,idade,nome,idTurma);
			DaoAluno daoAluno = new DaoAluno();
			daoAluno.incluir(this.alunoSelecionado);
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}
		
		this.finalizar();
	}
}
