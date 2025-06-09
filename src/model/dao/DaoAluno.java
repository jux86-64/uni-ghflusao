package model.dao;

import java.util.HashSet;
import java.util.Set;

import model.Aluno;

public class DaoAluno {
	
	// ATRIBUTOS
	private static Set<Aluno> conjAlunos = new HashSet<Aluno>();
	
	
	// METODOS
	public DaoAluno() {
	}
	
	public boolean incluir(Aluno alunoParaInclusao) {
		if(this.consultarPorMatricula(alunoParaInclusao.getMatricula()) != null)
			return false;
		DaoAluno.conjAlunos.add(alunoParaInclusao);
		return true;
	}
	
	
	public Aluno consultarPorMatricula(int matricula) {
		for(Aluno a  : DaoAluno.conjAlunos)
			if(a.getMatricula() == matricula)
				return a;
		return null;
	}
	
	public Aluno[] consultarTodos() {
		int tamanho = DaoAluno.conjAlunos.size();
		Aluno[] retorno = new Aluno[tamanho];
		int i = 0;
		for(Aluno a : DaoAluno.conjAlunos)
			retorno[i++] = a;
		return retorno;
	}
}
