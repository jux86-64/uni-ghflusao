package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAluno = new JButton(" Aluno");
		btnAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
			}
		});
		
		btnAluno.setBounds(37, 35, 186, 62);
		contentPane.add(btnAluno);
		
		JButton btnTurma = new JButton("Turma");
		btnTurma.setBounds(235, 35, 186, 62);
		contentPane.add(btnTurma);
		
		JButton btnDisciplina = new JButton("Disciplina");
		btnDisciplina.setBounds(37, 109, 186, 62);
		contentPane.add(btnDisciplina);
		
		this.setVisible(true);
	}
}
