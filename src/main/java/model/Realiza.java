package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Realiza {
		
		// CONSTANTES
		final public static int MAX_QTD_CARACTERES = 255;
		
		// ATRIBUTOS
		@Id @GeneratedValue
		private int idRealiza;
		@Column
		private double nota;
		
		// ATRIBUTOS DE RELACIONAMENTO
		@OneToMany(mappedBy="idCursa")
		private Set<Cursa> conjIdCursa;
		@ManyToOne(fetch = FetchType.LAZY)
		private Set<Prova> conjIdProva;
		
		// METODOS
		public Realiza(int idRealiza, double nota, Set<Cursa> conjIdCursa, Set<Prova> conjIdProva) throws Exception {
			super();
			this.idRealiza = idRealiza;
			this.nota = nota;
			this.conjIdCursa = conjIdCursa;
			this.conjIdProva = conjIdProva;
		}

		public int getIdRealiza() {
			return idRealiza;
		}

		public void setIdRealiza(int idRealiza) throws Exception {
			this.idRealiza = idRealiza;
		}

		public double getNota() {
			return nota;
		}

		public void setNota(double nota) throws Exception  {
			this.nota = nota;
		}

		public Set<Cursa> getConjIdCursa() {
			return conjIdCursa;
		}

		public void setConjIdCursa(Set<Cursa> conjIdCursa) throws Exception {
			this.conjIdCursa = conjIdCursa;
		}

		public Set<Prova> getConjIdProva() {
			return conjIdProva;
		}

		public void setConjIdProva(Set<Prova> conjIdProva) throws Exception {
			this.conjIdProva = conjIdProva;
		}
		
}
