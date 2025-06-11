package model.dao;

import java.util.List;

import com.mysql.cj.Query;

import controller.CtrlPrograma;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NamedQuery;
import model.Aluno;

@NamedQuery(name = "Aluno.matricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")
public class DaoAluno {
	
	// ATRIBUTOS
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	
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
	
	public Aluno[] consultarAlunoTodos() {
		jakarta.persistence.Query query = entityManager.createNamedQuery("Aluno.all");
		List<Aluno> resultado  = query.getResultList();
		Aluno[] retorno = new Aluno[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
