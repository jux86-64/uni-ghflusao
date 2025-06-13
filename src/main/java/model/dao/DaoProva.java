package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Prova;

@NamedQueries ({
	@NamedQuery(name = "Prova.idProva", query = "SELECT p FROM Prova p WHERE p.idProva = :idProva")
})
public class DaoProva {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public DaoProva() {
	}
	
	/*
	 * @param c
	 * @return
	 * */
	
	public boolean incluir(Prova p) {
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
	
	public boolean alterar(Prova p) {
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
	
	public boolean remover(Prova p) {
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
	
	public Prova consultarProvaPorID(int idProva) {
		TypedQuery<Prova> query = entityManager.createQuery("SELECT c FROM Prova c WHERE c.idProva = :idProva", Prova.class);
		query.setParameter("idProva", idProva);
		List<Prova> resultado = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		
		return null;
	}
	
	public static Prova[] obterIdProvaTodos() {
		javax.persistence.Query query  =  entityManager.createQuery("SELECT idProva FROM Prova");
		List<Prova> resultado = query.getResultList();
		Prova[] retorno = new Prova[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}