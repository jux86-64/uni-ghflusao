package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Realiza;

@NamedQueries ({
	@NamedQuery(name = "Realiza.idRealiza", query = "SELECT r FROM Realiza r WHERE r.idRealiza = :idRealiza")
})
public class DaoRealiza {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public DaoRealiza() {
	}
	
	/*
	 * @param r
	 * @return
	 * */
	
	public boolean incluir(Realiza r) {
		entityManager.getTransaction().begin();
		
		try {
			entityManager.persist(r);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean alterar(Realiza r) {
		entityManager.getTransaction().begin();

		try {
			entityManager.persist(r);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean remover(Realiza r) {
		entityManager.getTransaction().begin();

		try {
			entityManager.persist(r);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Realiza consultarRealizaPorID(int idRealiza) {
		TypedQuery<Realiza> query = entityManager.createQuery("SELECT c FROM Realiza c WHERE c.idRealiza = :idRealiza", Realiza.class);
		query.setParameter("idRealiza", idRealiza);
		List<Realiza> resultado = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		
		return null;
	}
	
	public static Realiza[] obterIdRealizaTodos() {
		javax.persistence.Query query  =  entityManager.createQuery("SELECT idRealiza FROM Realiza");
		List<Realiza> resultado = query.getResultList();
		Realiza[] retorno = new Realiza[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}