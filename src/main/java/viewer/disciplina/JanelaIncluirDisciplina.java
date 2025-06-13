package viewer.disciplina;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.aluno.CtrlAbstratoAluno;
import controller.disciplina.CtrlAbstratoDisciplina;
import controller.disciplina.CtrlIncluirDisciplina;
import viewer.JanelaAbstrata;

public class JanelaIncluirDisciplina extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNome;
	private JTextField tfCredito;
	
	final private boolean habilitarProcura;
	private boolean	disciplinaSelecionado;

	/**
	 * Create the frame.
	 */
	public JanelaIncluirDisciplina(CtrlAbstratoDisciplina ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.disciplinaSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Disciplina");
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 286, 301);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(27, 88, 55, 15);
		contentPane.add(lblNome);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(27, 42, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblCredito = new JLabel("Credito");
		lblCredito.setBounds(27, 128, 55, 15);
		contentPane.add(lblCredito);
		
		tfId = new JTextField();
		tfId.setBounds(72, 40, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setBounds(72, 86, 162, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCredito = new JTextField();
		tfCredito.setBounds(82, 126, 104, 19);
		contentPane.add(tfCredito);
		tfCredito.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String nome = tfNome.getText();
				int credito;
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Disciplina inválido " + aux);
					return;
				}
				
				aux = tfCredito.getText();
				try {
					credito = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Credito Disciplina inválido " + aux);
					return;
				}
				
				CtrlIncluirDisciplina ctrl = (CtrlIncluirDisciplina)getCtrl();
				ctrl.efetuar(id,nome,credito);
			}
		});
		btnCadastrar.setBounds(27, 182, 110, 43);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoDisciplina ctrl = (CtrlAbstratoDisciplina)getCtrl();
				ctrl.finalizar();
			}
		});
		btnSair.setBounds(149, 182, 82, 43);
		contentPane.add(btnSair);
	}

}
