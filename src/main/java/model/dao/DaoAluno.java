package main.java.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;

import com.mysql.cj.Query;

import controller.CtrlPrograma;
import model.Aluno;

@NamedQuery(name = "Aluno.matricula", query = "SELECT a FROM Aluno a WHERE a.matricula = :matricula")
public class DaoAluno {
	
	// ATRIBUTOS
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	
	// METODOS
	public DaoAluno() {
	}
	
	/*
	 * @param a
	 * @return
	 * */
	public boolean incluir(Aluno a) {		
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(a);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean alterar(Aluno a) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(a);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean remover(Aluno a) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(a);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Aluno consultarAlunoPorMatricula(int matricula) {
		javax.persistence.Query query = entityManager.createQuery("SELECT a FROM Aluno a");
		query.setParameter("matricula", matricula);
		List<Aluno> resultado = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
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
