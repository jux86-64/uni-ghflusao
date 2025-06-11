package model.dao;

import java.util.List;

import com.mysql.cj.Query;

import controller.CtrlPrograma;
import javax.persistence.*;
import model.Turma;

@NamedQueries ({
	@NamedQuery(name = "Turma.idTurma", query = "SELECT t FROM Turma t WHERE t.idTurma = :idTurma")
})
public class DaoTurma {
	
	private static EntityManager entityManager = CtrlPrograma.getEntityManager();
	
	public static Turma[] obterIdTurmaTodos() {
		jakarta.persistence.Query query  =  entityManager.createQuery("SELECT idTurma FROM Turma");
		List<Turma> resultado = query.getResultList();
		Turma[] retorno = new Turma[resultado.size()];
		for(int i = 0; i < resultado.size(); i++)
			retorno[i] = resultado.get(i);
		return retorno;
	}
}
