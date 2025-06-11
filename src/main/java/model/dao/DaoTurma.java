package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Turma;

@NamedQueries ({
	@NamedQuery(name = "Turma.idTurma", query = "SELECT t FROM Turma t WHERE t.idTurma = :idTurma")
})
public class DaoTurma {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public DaoTurma() {
	}
	
	/*
	 * @param t
	 * @return
	 * */
	
	public boolean incluir(Turma t) {
		entityManager.getTransaction().begin();
		
		try {
			entityManager.persist(t);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean alterar(Turma t) {
		entityManager.getTransaction().begin();

		try {
			entityManager.persist(t);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean remover(Turma t) {
		entityManager.getTransaction().begin();

		try {
			entityManager.persist(t);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Turma consultarTurmaPorID(int idTurma) {
		TypedQuery<Turma> query = entityManager.createQuery("SELECT t FROM Turma t WHERE t.idTurma = :idTurma", Turma.class);
		query.setParameter("idTurma", idTurma);
		List<Turma> resultado = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		
		return null;
	}
	
	public Turma[] obterIdTurmaTodos() {
		javax.persistence.Query query  =  entityManager.createQuery("SELECT idTurma FROM Turma");
		List<Turma> resultado = query.getResultList();
		Turma[] retorno = new Turma[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
