package viewer.aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;
import viewer.JanelaAbstrata;

public class JanelaAluno extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JanelaAluno(CtrlPrograma c) {
		super(c);
		
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar Aluno");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarIncluirAluno();
			}
		});
		btnCadastrarAluno.setBounds(37, 12, 156, 74);
		contentPane.add(btnCadastrarAluno);
		
		this.setVisible(true);
	}

}
