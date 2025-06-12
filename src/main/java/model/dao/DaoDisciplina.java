package model.dao;

import controller.CtrlPrograma;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import model.Disciplina;

@NamedQuery(name="Disciplina.idDisciplina", query = "SELECT d FROM Disciplina d WHERE d.idDisciplina = :numero")
public class DaoDisciplina {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	// METODOS
	public DaoDisciplina() {
	}
	
	/*
	 * @param d
	 * @return 
	 * */
	public boolean incluir(Disciplina d) {		
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(d);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean alterar(Disciplina d) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(d);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}

	public boolean remover(Disciplina d) {
		entityManager.getTransaction().begin();
		try {
			entityManager.persist(d);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Disciplina consultarDisciplinaPorID(int idDisciplina) {
		Query query = entityManager.createQuery("SELECT d FROM Disciplina d");
		query.setParameter("idDisciplina", idDisciplina);
		List<Disciplina> resultado  = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}
	
	public static Disciplina[] consultarDisciplinaTodos() {
		Query query = entityManager.createNamedQuery("Disciplina.all");
		List<Disciplina> resultado  = query.getResultList();
		Disciplina[] retorno = new Disciplina[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}

}
