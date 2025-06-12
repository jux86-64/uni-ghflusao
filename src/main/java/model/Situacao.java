package model;

public enum Situacao {
	ATIVA("Ativa"),
	INATIVA("Inativa"),
	CONCLUIDA("Concluida"),
	CANCELADA("Cancelada");
	
	private final String nome;
	
	private Situacao(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public static Situacao[] obterTodos() {
		Situacao[] retorno = {ATIVA,INATIVA,CONCLUIDA,CANCELADA};
		return retorno;
	}
}
