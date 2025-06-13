package model.validacao;

import java.util.regex.Pattern;

import model.Departamento;

public class ValidarDepartamento {
	 // Padrão regex para validar nome da disciplina (permite letras, acentos, espaços e hífens)
    private static final Pattern NOME_PATTERN = Pattern.compile("^[\\p{L} .'-]+$");

    public static void validarDepartamento(Departamento departamento) throws Exception {
        if (departamento == null)
            throw new Exception("departamento não pode ser nula");

        validarIdDepartamento(departamento.getIdDepartamento());
        validarNome(departamento.getNome());
    }

    public static void validarIdDepartamento(int idDepartamento) throws Exception {
        if (idDepartamento <= 0)
            throw new Exception("ID Departamento deve ser um número positivo");
    }

    public static void validarNome(String nome) throws Exception {
        if (nome == null || nome.isBlank())
            throw new Exception("Nome da Departamento não pode ser nulo ou vazio");

        if (nome.length() > Departamento.MAX_QTD_CARACTERES)
            throw new Exception("Nome da Departamento não pode ter mais que " + Departamento.MAX_QTD_CARACTERES + " caracteres");

        if (!NOME_PATTERN.matcher(nome).matches())
            throw new Exception("Nome da Departamento deve conter apenas letras e caracteres válidos");
    }
}
