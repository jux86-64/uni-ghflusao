package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlAbstrato;
import controller.CtrlPrograma;
import viewer.aluno.JanelaIncluirAluno;
import viewer.departamento.JanelaIncluirDepartamento;
import viewer.disciplina.JanelaIncluirDisciplina;
import viewer.professor.JanelaIncluirProfessor;
import viewer.turma.JanelaIncluirTurma;

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
		setBounds(100, 100, 450, 379);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAluno = new JButton("Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIncluirAluno meuViewer = new JanelaIncluirAluno(null, false);
				meuViewer.setVisible(true);
			}
		});
		
		btnAluno.setBounds(37, 35, 186, 62);
		contentPane.add(btnAluno);
		
		JButton btnTurma = new JButton("Turma");
		btnTurma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIncluirTurma meuViewer = new JanelaIncluirTurma(null, false);
				meuViewer.setVisible(true);
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
				JanelaIncluirProfessor meuViewer = new JanelaIncluirProfessor(null, false);
				meuViewer.setVisible(true);
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
		btnSair.setBounds(37, 279, 384, 31);
		contentPane.add(btnSair);
		
		this.setVisible(true);
	}
}
