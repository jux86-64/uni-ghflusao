package model.enumerado;

public enum Turno {
	MATUTINO("Matutino"),
	VESPERTINO("Vespertino"),
	NOTURNO("Noturno");
	
	private final String nome;
	
	private Turno(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public String toString() {
		return this.nome;
	}
	
	public static Turno[] obterTodos() {
		Turno[] retorno = {MATUTINO,VESPERTINO,NOTURNO};
		return retorno;
	}
}
