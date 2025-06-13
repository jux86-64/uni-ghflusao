package model.validacao;

import java.util.Set;
import java.util.regex.Pattern;
import model.Aluno;
import model.Cursa;
import model.Turma;

public class ValidarCursa {

    private static final Pattern DATA_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    private static final int ANO_MINIMO = 2000;
    private static final int ANO_MAXIMO = java.time.LocalDate.now().getYear() + 1;

    public static void validarCursa(Cursa cursa) throws Exception {
        if (cursa == null)
            throw new Exception("Cursa não pode ser nula");

        validarIdCursa(cursa.getIdCursa());
        validarData(cursa.getData_c());
        validarConjIdAluno(cursa.getConjIdAluno());
        validarConjIdTurma(cursa.getConjIdTurma());
    }

    public static void validarIdCursa(int idCursa) throws Exception {
        if (idCursa <= 0)
            throw new Exception("ID Cursa deve ser um número positivo");
    }

    public static void validarData(String data) throws Exception {
        if (data == null || data.isBlank())
            throw new Exception("Data não pode ser nula ou vazia");

        if (!DATA_PATTERN.matcher(data).matches())
            throw new Exception("Data deve estar no formato DD/MM/AAAA");

        try {
            java.time.LocalDate dataCursa = java.time.LocalDate.parse(data, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int ano = dataCursa.getYear();

            if (ano < ANO_MINIMO || ano > ANO_MAXIMO) {
                throw new Exception("Ano da cursa deve estar entre " + ANO_MINIMO + " e " + ANO_MAXIMO);
            }
        } catch (java.time.format.DateTimeParseException e) {
            throw new Exception("Data inválida");
        }
    }

    public static void validarConjIdAluno(Set<Aluno> conjIdAluno) throws Exception {
        if (conjIdAluno == null)
            throw new Exception("Conjunto de alunos não pode ser nulo");
    }

    public static void validarConjIdTurma(Set<Turma> conjIdTurma) throws Exception {
        if (conjIdTurma == null)
            throw new Exception("Conjunto de turmas não pode ser nulo");
    }
}