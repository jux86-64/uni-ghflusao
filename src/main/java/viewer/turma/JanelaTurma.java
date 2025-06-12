package viewer.turma;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlPrograma;
import viewer.JanelaAbstrata;

public class JanelaTurma extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;

	/**
	 * Create the frame.
	 */
	public JanelaTurma(CtrlPrograma c) {
		super(c);
		
		setTitle("Turma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar Turma");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlPrograma ctrl = (CtrlPrograma)getCtrl();
				ctrl.iniciarIncluirTurma();
			}
		});
		btnCadastrar.setBounds(41, 28, 156, 74);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Turma");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterar.setBounds(41, 114, 156, 74);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar Turma");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletar.setBounds(41, 200, 156, 74);
		contentPane.add(btnDeletar);
		
		tfId = new JTextField();
		tfId.setBounds(12, 319, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(31, 304, 55, 15);
		contentPane.add(lblMatricula);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setBounds(118, 319, 79, 18);
		contentPane.add(btnBuscar);
		
		this.setVisible(true);
	}
}
