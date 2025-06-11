package model.validacao;

import java.util.regex.Pattern;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import model.Turma;
import model.Disciplina;

public class ValidarTurma {

	private static final Pattern TURNO_PATTERN = Pattern.compile("^(MATUTINO|VESPERTINO|NOTURNO)$",
			Pattern.CASE_INSENSITIVE);
	private static final Pattern SITUACAO_PATTERN = Pattern.compile("^(ATIVA|INATIVA|CONCLUIDA|CANCELADA)$",
			Pattern.CASE_INSENSITIVE);
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
		validarIdProfessor(turma.getIdProfessor());
		validarIdDisciplina(turma.getIdDisciplina());
	}

	public static void validarIdTurma(int idTurma) throws Exception {
		if (idTurma <= 0)
			throw new Exception("ID Turma deve ser um número positivo");
	}

	public static void validarTurno(String turno) throws Exception {
		if (turno == null || turno.isBlank())
			throw new Exception("Turno não pode ser nulo ou vazio");

		if (turno.length() > Turma.MAX_QTD_CARACTERES)
			throw new Exception("Turno não pode ter mais que " + Turma.MAX_QTD_CARACTERES + " caracteres");

		if (!TURNO_PATTERN.matcher(turno).matches())
			throw new Exception("Turno deve ser MATUTINO, VESPERTINO ou NOTURNO");
	}

	public static void validarSituacao(String situacao) throws Exception {
		if (situacao == null || situacao.isBlank())
			throw new Exception("Situação não pode ser nula ou vazia");

		if (situacao.length() > Turma.MAX_QTD_CARACTERES)
			throw new Exception("Situação não pode ter mais que " + Turma.MAX_QTD_CARACTERES + " caracteres");

		if (!SITUACAO_PATTERN.matcher(situacao).matches())
			throw new Exception("Situação deve ser ATIVA, INATIVA, CONCLUÍDA ou CANCELADA");
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

	public static void validarIdProfessor(int idProfessor) throws Exception {
		if (idProfessor <= 0)
			throw new Exception("ID Professor deve ser um número positivo");
	}

	public static void validarIdDisciplina(Disciplina disciplina) throws Exception {
		if (disciplina == null)
			throw new Exception("Disciplina não pode ser nula");

		// Aqui você pode adicionar mais validações específicas da disciplina se
		// necessário
	}
}
