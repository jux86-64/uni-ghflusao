package viewer.aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;
import viewer.JanelaAbstrata;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class JanelaAluno extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula;

	/**
	 * Create the frame.
	 */
	public JanelaAluno(CtrlPrograma c) {
		super(c);
		
		setTitle("Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar Aluno");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarIncluirAluno();
			}
		});
		btnCadastrar.setBounds(41, 28, 156, 74);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Aluno");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterar.setBounds(41, 114, 156, 74);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar Aluno");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletar.setBounds(41, 200, 156, 74);
		contentPane.add(btnDeletar);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(12, 319, 104, 19);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(31, 304, 55, 15);
		contentPane.add(lblMatricula);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnBuscar.setBounds(118, 319, 79, 18);
		contentPane.add(btnBuscar);
		
		this.setVisible(true);
	}
}
