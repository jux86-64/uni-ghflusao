package controller;

import model.Aluno;
import model.Turma;
import viewer.IViewer;
import viewer.JanelaAluno;

public class CtrlIncluirAluno {
	
	// ATRIBUTOS
	private Aluno alunoCriado;
	private IViewer meuViewer;
	
	// MÉTODOS
	public CtrlIncluirAluno(ICtrl c) {
		super(); // TODO qq isso mds ---> super(c, "Incluir Livro", false);
		this.meuViewer.apresentar();
		this.alunoCriado = null;
	}
	
	
	// MÉTODO DE INCLUSÃO
	public void efetuarInclusao(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Turma idTurma) {
		try {
			this.alunoCriado = new Aluno(idAluno,matricula,cpf,telefone,endereco,idade,nome,idTurma);
			// TODO parecido com o CtrlIncluirLivro
		} catch (Exception e1) {
			this.meuViewer.notificar("Erro: " + e1);
			return;
		}
		this.finalizar();
	}
}
