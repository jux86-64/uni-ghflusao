
public class Disciplina {
	
	private int idDisciplina;
	private String nome;
	private float credito;
	
	public Disciplina(int idDisciplina, String nome, float credito) {
		super();
		this.idDisciplina = idDisciplina;
		this.nome = nome;
		this.credito = credito;
	}

	public int getIdDisciplina() {
		return idDisciplina;
	}

	public void setIdDisciplina(int idDisciplina) throws Exception {
		this.idDisciplina = idDisciplina;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) throws Exception {
		this.nome = nome;
	}

	public float getCredito() {
		return credito;
	}

	public void setCredito(float credito) throws Exception {
		this.credito = credito;
	}
	
	
}
