
public class Aluno { 

    private int idAluno;
    private int matricula;
    private String cpf;
    private String telefone;
    private String endereco;
    private int idade;
    private String nome;
    private Turma idTurma;

    public Aluno(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Turma idTurma) {
        this.idAluno = idAluno; 
        this.matricula = matricula;
        this.cpf = cpf;
        this.telefone = telefone;
        this.endereco = endereco;
        this.idade = idade; 
        this.nome = nome;
        this.idTurma = idTurma;
    }

    public int getIdAluno() {
        return idAluno;
    }

    public void setIdAluno(int idAluno) throws Exception {
        this.idAluno = idAluno;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) throws Exception {
        this.matricula = matricula;
    }

    public String getCpf() { 
        return cpf;
    }

    public void setCpf(String cpf) throws Exception {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) throws Exception {
        this.telefone = telefone;
    }

    public String getEndereco() { 
        return endereco;
    }

    public void setEndereco(String endereco) throws Exception {
        this.endereco = endereco;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) throws Exception {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws Exception {
        this.nome = nome;
    }

    public int getIdTurma() {
        return idTurma;
    } 
    
    public void setIdTurma(Turma idTurma) throws Exception {
        this.idTurma = idTurma;
    }
}