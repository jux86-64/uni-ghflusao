package viewer.professor;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.professor.CtrlAbstratoProfessor;
import viewer.JanelaAbstrata;

public class JanelaProfessor extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	
	final private boolean 	habilitarProcura;

	/**
	 * Create the frame.
	 */
	public JanelaProfessor(CtrlAbstratoProfessor ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.habilitarProcura = habilitarProcura;
		
		setTitle("Professor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 240, 425);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar Professor");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JanelaIncluirProfessor meuViewer = new JanelaIncluirProfessor(null, false);
				meuViewer.setVisible(true);
			}
		});
		btnCadastrar.setBounds(41, 28, 156, 74);
		contentPane.add(btnCadastrar);
		
		JButton btnAlterar = new JButton("Alterar Professor");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterar.setBounds(41, 114, 156, 74);
		contentPane.add(btnAlterar);
		
		JButton btnDeletar = new JButton("Deletar Professor");
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
		
		JLabel lblId = new JLabel("ID Professor");
		lblId.setBounds(31, 304, 55, 15);
		contentPane.add(lblId);
		
		JButton btnProcurarPorId = new JButton("Buscar");
		btnProcurarPorId.setBounds(118, 319, 79, 18);
		contentPane.add(btnProcurarPorId);
		
		if(habilitarProcura) {
			btnProcurarPorId = new JButton("Buscar por ID");
			btnProcurarPorId.setBounds(54, 341, 153, 25);
			contentPane.add(btnProcurarPorId);
			btnProcurarPorId.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int idProfessor = Integer.parseInt(tfId.getText());
					CtrlAbstratoProfessor ctrl = (CtrlAbstratoProfessor)getCtrl();
					ctrl.procurarProfessorPorId(idProfessor);
				}
			});
		}
		
		this.setVisible(true);
	}
}
