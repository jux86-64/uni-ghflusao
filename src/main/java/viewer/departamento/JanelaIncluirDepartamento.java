package viewer.departamento;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.departamento.CtrlAbstratoDepartamento;
import controller.departamento.CtrlIncluirDepartamento;
import viewer.JanelaAbstrata;

public class JanelaIncluirDepartamento extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNome;
	
	final private boolean habilitarProcura;
	private boolean departamentoSelecionado;

	/**
	 * Create the frame.
	 */
	public JanelaIncluirDepartamento(CtrlAbstratoDepartamento ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.departamentoSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Departamento");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 309, 305);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfId = new JTextField();
		tfId.setBounds(111, 47, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(111, 89, 104, 19);
		contentPane.add(tfNome);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(38, 49, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(38, 91, 55, 15);
		contentPane.add(lblNome);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String nome = tfNome.getText();
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Departamento inválido " + aux);
					return;
				}
				
				CtrlIncluirDepartamento ctrl = (CtrlIncluirDepartamento)getCtrl();
				ctrl.efetuar(id,nome);
			}
		});
		btnCadastrar.setBounds(83, 194, 98, 46);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoDepartamento ctrl = (CtrlAbstratoDepartamento)getCtrl();
				ctrl.finalizar();
			}
		});
		btnSair.setBounds(193, 194, 89, 46);
		contentPane.add(btnSair);
	}

}
