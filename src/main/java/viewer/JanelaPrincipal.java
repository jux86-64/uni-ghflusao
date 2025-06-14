package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import controller.aluno.CtrlAbstratoAluno;
import controller.cursa.CtrlAbstratoCursa;
import controller.professor.CtrlAbstratoProfessor;
import controller.prova.CtrlAbstratoProva;
import controller.turma.CtrlAbstratoTurma;
import viewer.aluno.JanelaAluno;
import viewer.cursa.JanelaCursa;
import viewer.departamento.JanelaIncluirDepartamento;
import viewer.disciplina.JanelaIncluirDisciplina;
import viewer.professor.JanelaProfessor;
import viewer.prova.JanelaProva;
import viewer.realiza.JanelaIncluirRealiza;
import viewer.turma.JanelaTurma;

public class JanelaPrincipal extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaPrincipal(CtrlPrograma c) {
		super(c);
		setTitle("Menu Principal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoAluno c = null;
				JanelaAluno janela = new JanelaAluno(c,false);
				janela.apresentar();
			}
		});
		
		btnAluno.setBounds(37, 35, 186, 62);
		contentPane.add(btnAluno);
		
		JButton btnTurma = new JButton("Turma");
		btnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoTurma c = null;
				JanelaTurma janela = new JanelaTurma(c,false);
				janela.apresentar();
			}
		});
		btnTurma.setBounds(235, 35, 186, 62);
		contentPane.add(btnTurma);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIncluirDisciplina meuViewer = new JanelaIncluirDisciplina(null, false);
				meuViewer.setVisible(true);
			}
		});
		btnDisciplina.setBounds(37, 109, 186, 62);
		contentPane.add(btnDisciplina);
		
		JButton btnProfessor = new JButton("Professor");
		btnProfessor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoProfessor c = null;
				JanelaProfessor janela = new JanelaProfessor(c,false);
				janela.apresentar();
			}
		});
		btnProfessor.setBounds(235, 109, 186, 62);
		contentPane.add(btnProfessor);
		
		JButton btnDepartamento = new JButton("Departamento");
		btnDepartamento.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIncluirDepartamento meuViewer = new JanelaIncluirDepartamento(null, false);
				meuViewer.setVisible(true);
			}
		});
		btnDepartamento.setBounds(37, 183, 186, 62);
		contentPane.add(btnDepartamento);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstrato ctrl = (CtrlAbstrato)getCtrl();
				ctrl.finalizar();	
			}
		});
		btnSair.setBounds(37, 350, 384, 31);
		contentPane.add(btnSair);
		
		JButton btnCursa = new JButton("Cursa");
		btnCursa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoCursa c = null;
				JanelaCursa janela = new JanelaCursa(c,false);
				janela.apresentar();
			}
		});
		btnCursa.setBounds(235, 183, 186, 62);
		contentPane.add(btnCursa);
		
		JButton btnProva = new JButton("Prova");
		btnProva.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoProva c = null;
				JanelaProva janela = new JanelaProva(c,false);
				janela.apresentar();
			}
		});
		btnProva.setBounds(37, 257, 186, 62);
		contentPane.add(btnProva);
		
		JButton btnRealiza = new JButton("Realiza");
		btnRealiza.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIncluirRealiza meuViewer = new JanelaIncluirRealiza(null, false);
				meuViewer.setVisible(true);
			}
		});
		btnRealiza.setBounds(235, 257, 186, 62);
		contentPane.add(btnRealiza);
		
		this.setVisible(true);
	}
}
