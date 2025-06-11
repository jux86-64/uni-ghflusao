package main.java.model.validacao;



import java.util.regex.Pattern;

import model.Aluno;
import model.Turma;

public class ValidarAluno {

	// Padrão regex para validar CPF (formato 000.000.000-00)
	private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");

	// Padrão regex para validar telefone (aceita diversos formatos)
	private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}[\\s-]?\\d{4}$");

	private static final int IDADE_MINIMA = 3;
	private static final int IDADE_MAXIMA = 120;

	public static void validarAluno(Aluno aluno) throws Exception {
		if (aluno == null)
			throw new Exception("Aluno não pode ser nulo");

		validarIdAluno(aluno.getIdAluno());
		validarMatricula(aluno.getMatricula());
		validarCpf(aluno.getCpf());
		validarTelefone(aluno.getTelefone());
		validarEndereco(aluno.getEndereco());
		validarIdade(aluno.getIdade());
		validarNome(aluno.getNome());
		validarIdTurma(aluno.getIdTurma());
	}

	public static void validarIdAluno(int idAluno) throws Exception {
		if (idAluno == 0)
			throw new Exception("ID Aluno não pode ser nulo");
	}

	public static void validarMatricula(int matricula) throws Exception {
		if (matricula <= 0)
			throw new Exception("Matrícula deve ser um número positivo");
	}

	public static void validarCpf(String cpf) throws Exception {
		if (cpf == null || cpf.isBlank())
			throw new Exception("CPF não pode ser nulo ou vazio");

		if (cpf.length() != Aluno.TAM_CPF)
			throw new Exception("CPF deve ter " + Aluno.TAM_CPF + " caracteres");

		if (!CPF_PATTERN.matcher(cpf).matches())
			throw new Exception("CPF deve estar no formato 000.000.000-00");

	}

	public static void validarTelefone(String telefone) throws Exception {
		if (telefone == null || telefone.isBlank())
			throw new Exception("Telefone não pode ser nulo ou vazio");

		if (!TELEFONE_PATTERN.matcher(telefone).matches())
			throw new Exception("Telefone deve estar em um formato válido");
	}

	public static void validarEndereco(String endereco) throws Exception {
		if (endereco == null || endereco.isBlank())
			throw new Exception("Endereço não pode ser nulo ou vazio");

		if (endereco.length() > Aluno.MAX_QTD_CARACTERES)
			throw new Exception("Endereço não pode ter mais que " + Aluno.MAX_QTD_CARACTERES + " caracteres");
	}

	public static void validarIdade(int idade) throws Exception {
		if (idade < IDADE_MINIMA || idade > IDADE_MAXIMA)
			throw new Exception("Idade deve estar entre " + IDADE_MINIMA + " e " + IDADE_MAXIMA);
	}

	public static void validarNome(String nome) throws Exception {
		if (nome == null || nome.isBlank())
			throw new Exception("Nome não pode ser nulo ou vazio");

		if (nome.length() > Aluno.MAX_QTD_CARACTERES)
			throw new Exception("Nome não pode ter mais que " + Aluno.MAX_QTD_CARACTERES + " caracteres");

		if (!nome.matches("^[\\p{L} .'-]+$"))
			throw new Exception("Nome deve conter apenas letras e caracteres válidos");

	}

	public static void validarIdTurma(Turma idTurma) throws Exception {
		if (idTurma == null)
			throw new Exception("ID Turma não pode ser nulo");

		// TODO adicionar mais validações específicas da turma
	}
}
