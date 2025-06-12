package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
	
	// CONSTANTES
	final public static int MAX_QTD_CARACTERES = 255;
	
	// ATRIBUTOS
	@Id @GeneratedValue
	private int idProfessor;
	@Column
	private String nome;
	@Column
	private String endereco;
	@Column
	private String telefone;
	@Column
	private String cpf;
	@Column
	private String especialidade;
	@Column
	private Departamento idDepartamento;
	
	
	// ATRIBUTO DE RELACIONAMENTO
	
	
	
}
