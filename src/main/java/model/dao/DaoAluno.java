package main.java.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;

import controller.CtrlPrograma;
import model.Aluno;

@NamedQuery(name = "Aluno.matricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")
public class DaoAluno {
	
	// ATRIBUTOS
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	
	// METODOS
	public DaoAluno() {
	}
	
	
	
	public Aluno[] consultarAlunoTodos() {
		javax.persistence.Query query = entityManager.createNamedQuery("Aluno.all");
		List<Aluno> resultado  = query.getResultList();
		Aluno[] retorno = new Aluno[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
