package model.validacao;

import java.util.Set;
import model.Cursa;
import model.Prova;
import model.Realiza;

public class ValidarRealiza {

    // Constantes para validação de nota
    private static final double NOTA_MINIMA = 0.0;
    private static final double NOTA_MAXIMA = 10.0;

    public static void validarRealiza(Realiza realiza) throws Exception {
        if (realiza == null)
            throw new Exception("Realiza não pode ser nulo");

        validarIdRealiza(realiza.getIdRealiza());
        validarNota(realiza.getNota());
        validarConjIdCursa(realiza.getConjIdCursa());
        validarConjIdProva(realiza.getConjIdProva());
    }

    public static void validarIdRealiza(int idRealiza) throws Exception {
        if (idRealiza <= 0)
            throw new Exception("ID Realiza deve ser um número positivo");
    }

    public static void validarNota(double nota) throws Exception {
        if (nota < NOTA_MINIMA || nota > NOTA_MAXIMA)
            throw new Exception("Nota deve estar entre " + NOTA_MINIMA + " e " + NOTA_MAXIMA);
    }

    public static void validarConjIdCursa(Set<Cursa> conjIdCursa) throws Exception {
        if (conjIdCursa == null)
            throw new Exception("Conjunto de cursas não pode ser nulo");
    }

    public static void validarConjIdProva(Set<Prova> conjIdProva) throws Exception {
        if (conjIdProva == null)
            throw new Exception("Conjunto de provas não pode ser nulo");
    }
}