package model;



import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import model.validacao.ValidarAluno;

@Entity
public class Aluno { 
	
	// CONSTANTES
	final public static int TAM_CPF = 14;
	final public static int MAX_QTD_CARACTERES = 255;
	
	
	// ATRIBUTOS
	@Id @GeneratedValue
    private int idAluno;
	
	@Column
    private int matricula;
	@Column(length=TAM_CPF, unique=true)
    private String cpf;
	@Column(length=MAX_QTD_CARACTERES)
    private String telefone;
	@Column(length=MAX_QTD_CARACTERES)
    private String endereco;
	@Column
    private int idade;
	@Column(length=MAX_QTD_CARACTERES)
    private String nome;
	
	
	
	// ATRIBUTOS DE RELACIONAMENTO
	@ManyToOne(fetch = FetchType.LAZY)
	private Set<Turma> conjIdTurma;
	

    public Aluno(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Turma idTurma)  throws Exception{
        this.idAluno = idAluno; 
        this.matricula = matricula;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idade = idade; 
        this.nome = nome;
        this.setConjIdTurma(new HashSet<Turma>());
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) throws Exception {
        ValidarAluno.validarIdAluno(idAluno);
    	this.idAluno = idAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws Exception {
        ValidarAluno.validarMatricula(matricula);
    	this.matricula = matricula;
    }

    public String getCpf() { 
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
    	ValidarAluno.validarCpf(cpf);
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        ValidarAluno.validarTelefone(telefone);
    	this.telefone = telefone;
    }

    public String getEndereco() { 
        return endereco;
    }

    public void setEndereco(String endereco) throws Exception {
        ValidarAluno.validarEndereco(endereco);
    	this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws Exception {
        ValidarAluno.validarIdade(idade);
    	this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        ValidarAluno.validarNome(nome);
    	this.nome = nome;
    }
    
    public Set<Turma> getConjIdTurma() {
		return conjIdTurma;
	}

	public void setConjIdTurma(Set<Turma> conjIdTurma) throws Exception {
        ValidarAluno.validarConjIdTurma(conjIdTurma);
    	this.conjIdTurma = conjIdTurma;
    }
}