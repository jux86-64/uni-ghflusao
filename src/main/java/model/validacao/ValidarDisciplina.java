package model.validacao;

import java.util.regex.Pattern;

import model.Disciplina;

public class ValidarDisciplina {

    // Padrão regex para validar nome da disciplina (permite letras, acentos, espaços e hífens)
    private static final Pattern NOME_PATTERN = Pattern.compile("^[\\p{L} .'-]+$");

    // Constantes de validação
    private static final float CREDITO_MINIMO = 0.5f;
    private static final float CREDITO_MAXIMO = 10.0f;

    public static void validarDisciplina(Disciplina disciplina) throws Exception {
        if (disciplina == null)
            throw new Exception("Disciplina não pode ser nula");

        validarIdDisciplina(disciplina.getIdDisciplina());
        validarNome(disciplina.getNome());
        validarCredito(disciplina.getCredito());
    }

    public static void validarIdDisciplina(int idDisciplina) throws Exception {
        if (idDisciplina <= 0)
            throw new Exception("ID Disciplina deve ser um número positivo");
    }

    public static void validarNome(String nome) throws Exception {
        if (nome == null || nome.isBlank())
            throw new Exception("Nome da disciplina não pode ser nulo ou vazio");

        if (nome.length() > Disciplina.MAX_QTD_CARACTERES)
            throw new Exception("Nome da disciplina não pode ter mais que " + Disciplina.MAX_QTD_CARACTERES + " caracteres");

        if (!NOME_PATTERN.matcher(nome).matches())
            throw new Exception("Nome da disciplina deve conter apenas letras e caracteres válidos");
    }

    public static void validarCredito(float credito) throws Exception {
        if (credito < CREDITO_MINIMO || credito > CREDITO_MAXIMO)
            throw new Exception("Crédito da disciplina deve estar entre " + CREDITO_MINIMO + " e " + CREDITO_MAXIMO);
    }
}