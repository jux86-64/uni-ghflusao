package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import controller.CtrlPrograma;
import model.Cursa;

@NamedQueries ({
	@NamedQuery(name = "Cursa.idCursa", query = "SELECT c FROM Cursa c WHERE c.idCursa = :idCursa")
})
public class DaoCursa {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public DaoCursa() {
	}
	
	/*
	 * @param c
	 * @return
	 * */
	
	public boolean incluir(Cursa c) {
		entityManager.getTransaction().begin();
		
		try {
			entityManager.persist(c);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean alterar(Cursa c) {
		entityManager.getTransaction().begin();

		try {
			entityManager.persist(c);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public boolean remover(Cursa c) {
		entityManager.getTransaction().begin();

		try {
			entityManager.persist(c);
		} catch (PersistenceException e) {
			entityManager.getTransaction().rollback();
			return false;
		}
		entityManager.getTransaction().commit();
		return true;
	}
	
	public Cursa consultarCursaPorID(int idCursa) {
		TypedQuery<Cursa> query = entityManager.createQuery("SELECT c FROM Cursa c WHERE c.idCursa = :idCursa", Cursa.class);
		query.setParameter("idCursa", idCursa);
		List<Cursa> resultado = query.getResultList();
		if(resultado != null && resultado.size() > 0)
			return resultado.get(0);
		
		return null;
	}
	
	public static Cursa[] obterIdCursaTodos() {
		javax.persistence.Query query  =  entityManager.createQuery("SELECT idCursa FROM Cursa");
		List<Cursa> resultado = query.getResultList();
		Cursa[] retorno = new Cursa[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}