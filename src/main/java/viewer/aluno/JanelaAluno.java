package viewer.aluno;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.aluno.CtrlAbstratoAluno;
import viewer.JanelaAbstrata;

public class JanelaAluno extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfMatricula;
	
	final private boolean 	habilitarProcura;

	/**
	 * Create the frame.
	 */
	public JanelaAluno(CtrlAbstratoAluno ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.habilitarProcura = habilitarProcura;
		
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
				JanelaIncluirAluno meuViewer = new JanelaIncluirAluno(null, false);
				meuViewer.setVisible(true);
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
		
		JButton btnProcurarPorMatricula = new JButton("Buscar");
		btnProcurarPorMatricula.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		btnProcurarPorMatricula.setBounds(118, 319, 79, 18);
		contentPane.add(btnProcurarPorMatricula);
		
		if(habilitarProcura) {
			btnProcurarPorMatricula = new JButton("Buscar por Matricula");
			btnProcurarPorMatricula.setBounds(54, 341, 153, 25);
			contentPane.add(btnProcurarPorMatricula);
			btnProcurarPorMatricula.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int matricula = Integer.parseInt(tfMatricula.getText());
					CtrlAbstratoAluno ctrl = (CtrlAbstratoAluno)getCtrl();
					ctrl.procurarAlunoPorMatricula(matricula);
				}
			});
		}
		
		this.setVisible(true);
	}
}
