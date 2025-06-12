package model.validacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Set;
import java.util.regex.Pattern;

import model.Disciplina;
import model.Professor;
import model.Turma;
import model.enumerado.Situacao;
import model.enumerado.Turno;

public class ValidarTurma {

	private static final Pattern DATA_PATTERN = Pattern.compile("^\\d{2}/\\d{2}/\\d{4}$");

	// CONSTANTES
	private static final int ANO_MINIMO = 2000;
	private static final int ANO_MAXIMO = LocalDate.now().getYear() + 1;

	public static void validarTurma(Turma turma) throws Exception {
		if (turma == null)
			throw new Exception("Turma não pode ser nula");

		validarIdTurma(turma.getIdTurma());
		validarTurno(turma.getTurno());
		validarSituacao(turma.getSituacao());
		validarData(turma.getData_t());
		validarConjIdProfessor(turma.getConjIdProfessor());
		validarConjIdDisciplina(turma.getConjIdDisciplina());
	}

	public static void validarIdTurma(int idTurma) throws Exception {
		if (idTurma <= 0)
			throw new Exception("ID Turma deve ser um número positivo");
	}

	public static void validarTurno(Turno turno) throws Exception {
		if (turno == null)
			throw new Exception("É necessário indicar o turno da turma");
	}

	public static void validarSituacao(Situacao situacao) throws Exception {
		if (situacao == null)
			throw new Exception("É necessário indicar a situacao da turma");
	}

	public static void validarData(String data) throws Exception {
		if (data == null || data.isBlank())
			throw new Exception("Data não pode ser nula ou vazia");

		if (!DATA_PATTERN.matcher(data).matches())
			throw new Exception("Data deve estar no formato DD/MM/AAAA");

		try {
			LocalDate dataTurma = LocalDate.parse(data, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			int ano = dataTurma.getYear();

			if (ano < ANO_MINIMO || ano > ANO_MAXIMO) {
				throw new Exception("Ano da turma deve estar entre " + ANO_MINIMO + " e " + ANO_MAXIMO);
			}
		} catch (DateTimeParseException e) {
			throw new Exception("Data inválida");
		}
	}

	public static void validarConjIdProfessor(Set<Professor> conjIdProfessor) throws Exception {
		if (conjIdProfessor == null)
			throw new Exception("ID Professor deve ser um número positivo");
	}

	public static void validarConjIdDisciplina(Set<Disciplina> conjIdDisciplina) throws Exception {
		if (conjIdDisciplina == null)
			throw new Exception("Disciplina não pode ser nula");

	}
}
