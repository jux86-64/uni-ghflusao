package model.validacao;

import java.util.Set;
import java.util.regex.Pattern;
import model.Prova;
import model.Turma;

public class ValidarProva {

    private static final Pattern DATA_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");
    private static final int ANO_MINIMO = 2000;
    private static final int ANO_MAXIMO = java.time.LocalDate.now().getYear() + 1;
    private static final double PESO_MINIMO = 0.1;
    private static final double PESO_MAXIMO = 10.0;

    public static void validarProva(Prova prova) throws Exception {
        if (prova == null)
            throw new Exception("Prova não pode ser nula");

        validarIdProva(prova.getIdProva());
        validarData(prova.getData_p());
        validarPeso(prova.getPeso());
        validarConjIdTurma(prova.getConjIdTurma());
    }

    public static void validarIdProva(int idProva) throws Exception {
        if (idProva <= 0)
            throw new Exception("ID Prova deve ser um número positivo");
    }

    public static void validarData(String data) throws Exception {
        if (data == null || data.isBlank())
            throw new Exception("Data da prova não pode ser nula ou vazia");

        if (!DATA_PATTERN.matcher(data).matches())
            throw new Exception("Data da prova deve estar no formato DD/MM/AAAA");

        try {
            java.time.LocalDate dataProva = java.time.LocalDate.parse(data, java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            int ano = dataProva.getYear();

            if (ano < ANO_MINIMO || ano > ANO_MAXIMO) {
                throw new Exception("Ano da prova deve estar entre " + ANO_MINIMO + " e " + ANO_MAXIMO);
            }
        } catch (java.time.format.DateTimeParseException e) {
            throw new Exception("Data da prova inválida");
        }
    }

    public static void validarPeso(double peso) throws Exception {
        if (peso < PESO_MINIMO || peso > PESO_MAXIMO)
            throw new Exception("Peso da prova deve estar entre " + PESO_MINIMO + " e " + PESO_MAXIMO);
    }

    public static void validarConjIdTurma(Set<Turma> conjIdTurma) throws Exception {
        if (conjIdTurma == null)
            throw new Exception("Conjunto de turmas não pode ser nulo");
    }
}