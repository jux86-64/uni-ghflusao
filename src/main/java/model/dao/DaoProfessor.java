package model.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;

import com.mysql.cj.Query;

import controller.CtrlPrograma;
import model.Professor;

@NamedQuery(name = "Professor.matricula", query = "SELECT p FROM Professor p WHERE p.idProfessor = :idProfessor")
public class DaoProfessor {
	
	// ATRIBUTOS
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	
	// METODOS
	public DaoProfessor() {
	}
	
	/*
	 * @param p
	 * @return
	 * */
	public boolean incluir(Professor p) {		
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(p);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean alterar(Professor p) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(p);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean remover(Professor p) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(p);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Professor consultarProfessorPorID(int idProfessor) {
		javax.persistence.Query query = entityManager.createQuery("SELECT p FROM Professor p");
		query.setParameter("idProfessor", idProfessor);
		List<Professor> resultado = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
	
	public static Professor[] consultarProfessorTodos() {
		javax.persistence.Query query = entityManager.createNamedQuery("Professor.all");
		List<Professor> resultado  = query.getResultList();
		Professor[] retorno = new Professor[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}