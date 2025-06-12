package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import controller.CtrlPrograma;
import model.Departamento;

@NamedQuery(name = "Departamento.idDepartamento", query = "SELECT d FROM Departamento d WHERE d.idDepartamento = :idDepartamento")
public class DaoDepartamento {

	private static EntityManager entityManager = CtrlPrograma.getEntityManager();

	// METODOS
	public DaoDepartamento() {
	}

	/*
	 * @param d
	 * @return
	 */
	public boolean incluir(Departamento d) {
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

	public boolean alterar(Departamento d) {
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

	public boolean remover(Departamento d) {
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

	public Departamento consultarDepartamentoPorID(int idDepartamento) {
		Query query = entityManager.createQuery("SELECT d FROM Departamento d");
		query.setParameter("idDepartamento", idDepartamento);
		List<Departamento> resultado = query.getResultList();
		if (resultado != null && resultado.size() > 0)
			return resultado.get(0);
		return null;
	}

	public static Departamento[] consultarDepartamentoTodos() {
		Query query = entityManager.createNamedQuery("Departamento.all");
		List<Departamento> resultado = query.getResultList();
		Departamento[] retorno = new Departamento[resultado.size()];
		for (int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
