package model.validacao;

import java.util.Set;
import java.util.regex.Pattern;

import model.Departamento;
import model.Professor;

public class ValidarProfessor {

    // Padrão regex para validar CPF (formato 000.000.000-00)
    private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}$");

    // Padrão regex para validar telefone (aceita diversos formatos)
    private static final Pattern TELEFONE_PATTERN = Pattern.compile("^\\(?\\d{2}\\)?[\\s-]?\\d{4,5}[\\s-]?\\d{4}$");

    private static final int IDADE_MINIMA = 3;
	private static final int IDADE_MAXIMA = 120;
    
    public static void validarProfessor(Professor professor) throws Exception {
        if (professor == null)
            throw new Exception("Professor não pode ser nulo");

        validarIdProfessor(professor.getIdProfessor());
        validarNome(professor.getNome());
        validarEndereco(professor.getEndereco());
        validarTelefone(professor.getTelefone());
        validarCpf(professor.getCpf());
        validarIdade(professor.getIdade());
        validarEspecialidade(professor.getEspecialidade());
        validarConjIdDepartamento(professor.getConjIdDepartamento());
    }

    public static void validarIdProfessor(int idProfessor) throws Exception {
        if (idProfessor <= 0)
            throw new Exception("ID Professor deve ser um número positivo");
    }

    public static void validarNome(String nome) throws Exception {
        if (nome == null || nome.isBlank())
            throw new Exception("Nome do professor não pode ser nulo ou vazio");

        if (nome.length() > Professor.MAX_QTD_CARACTERES)
            throw new Exception("Nome do professor não pode ter mais que " + Professor.MAX_QTD_CARACTERES + " caracteres");

        if (!nome.matches("^[\\p{L} .'-]+$"))
            throw new Exception("Nome do professor deve conter apenas letras e caracteres válidos");
    }

    public static void validarEndereco(String endereco) throws Exception {
        if (endereco == null || endereco.isBlank())
            throw new Exception("Endereço do professor não pode ser nulo ou vazio");

        if (endereco.length() > Professor.MAX_QTD_CARACTERES)
            throw new Exception("Endereço do professor não pode ter mais que " + Professor.MAX_QTD_CARACTERES + " caracteres");
    }

    public static void validarTelefone(String telefone) throws Exception {
        if (telefone == null || telefone.isBlank())
            throw new Exception("Telefone do professor não pode ser nulo ou vazio");

        if (!TELEFONE_PATTERN.matcher(telefone).matches())
            throw new Exception("Telefone do professor deve estar em um formato válido");
    }

    public static void validarCpf(String cpf) throws Exception {
        if (cpf == null || cpf.isBlank())
            throw new Exception("CPF do professor não pode ser nulo ou vazio");

        if (cpf.length() != 14) // 000.000.000-00 tem 14 caracteres
            throw new Exception("CPF do professor deve ter 14 caracteres no formato 000.000.000-00");

        if (!CPF_PATTERN.matcher(cpf).matches())
            throw new Exception("CPF do professor deve estar no formato 000.000.000-00");
    }
    
    public static void validarIdade(int idade) throws Exception {
		if (idade < IDADE_MINIMA || idade > IDADE_MAXIMA)
			throw new Exception("Idade deve estar entre " + IDADE_MINIMA + " e " + IDADE_MAXIMA);
	}

    public static void validarEspecialidade(String especialidade) throws Exception {
        if (especialidade == null || especialidade.isBlank())
            throw new Exception("Especialidade do professor não pode ser nula ou vazia");

        if (especialidade.length() > Professor.MAX_QTD_CARACTERES)
            throw new Exception("Especialidade do professor não pode ter mais que " + Professor.MAX_QTD_CARACTERES + " caracteres");
    }

    public static void validarConjIdDepartamento(Set<Departamento> conjIdDepartamento) throws Exception {
        if (conjIdDepartamento == null)
            throw new Exception("Conjunto de departamentos não pode ser nulo");
    }
}
