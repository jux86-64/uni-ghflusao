package viewer.professor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.professor.CtrlAbstratoProfessor;
import controller.professor.CtrlIncluirProfessor;
import model.Departamento;
import viewer.JanelaAbstrata;

public class JanelaIncluirProfessor extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfEspecialidade;
	private JTextField tfIdade;
	private JTextField tfTelefone;
	private JTextField tfEndereco;
	private JTextField tfNome;
	private JTextField tfId;

	final private boolean habilitarProcura;
	private boolean professorSelecionado;
	private JTextField tfCpf;

	/**
	 * Create the frame.
	 */
	public JanelaIncluirProfessor (CtrlAbstratoProfessor ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.professorSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Aluno");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(25, 12, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(25, 45, 55, 15);
		contentPane.add(lblNome);
		
		JLabel lblEndereco = new JLabel("Endereco");
		lblEndereco.setBounds(25, 132, 55, 15);
		contentPane.add(lblEndereco);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(25, 174, 55, 15);
		contentPane.add(lblTelefone);
		
		JLabel lblEspecialidade = new JLabel("Especialidade");
		lblEspecialidade.setBounds(25, 221, 93, 15);
		contentPane.add(lblEspecialidade);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(25, 262, 55, 15);
		contentPane.add(lblIdade);
		
		JLabel lblIdDepartamento = new JLabel("ID Departamento");
		lblIdDepartamento.setBounds(25, 299, 106, 15);
		contentPane.add(lblIdDepartamento);
		
		JComboBox cbIdDepartamento = new JComboBox();
		cbIdDepartamento.setBounds(136, 294, 106, 24);
		contentPane.add(cbIdDepartamento);
		
		tfEspecialidade = new JTextField();
		tfEspecialidade.setBounds(136, 219, 178, 19);
		contentPane.add(tfEspecialidade);
		tfEspecialidade.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(136, 260, 104, 19);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		tfTelefone = new JTextField();
		tfTelefone.setColumns(10);
		tfTelefone.setBounds(138, 172, 104, 19);
		contentPane.add(tfTelefone);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(136, 130, 245, 19);
		contentPane.add(tfEndereco);
		
		tfNome = new JTextField();
		tfNome.setBounds(136, 43, 245, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfId = new JTextField();
		tfId.setBounds(138, 10, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String nome = tfNome.getText();
				String endereco = tfEndereco.getText();
				String telefone = tfTelefone.getText();
				String cpf = tfCpf.getText();
				String especialidade = tfEspecialidade.getText();
				int idade; 
				Departamento idDepartamento = (Departamento)cbIdDepartamento.getSelectedItem(); 
				
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Professor inválido " + aux);
					return;
				}
				
				aux = tfIdade.getText();
				try {
					idade = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Idade Idade inválido " + aux);
					return;
				}
				
				CtrlIncluirProfessor ctrl = (CtrlIncluirProfessor)getCtrl();
				ctrl.efetuar(id,nome,endereco,telefone,cpf,idade,especialidade,idDepartamento);
			}
		});
		btnCadastrar.setBounds(198, 337, 128, 56);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoProfessor ctrl = (CtrlAbstratoProfessor)getCtrl();
				ctrl.finalizar();
			}
		});
		btnSair.setBounds(332, 337, 106, 56);
		contentPane.add(btnSair);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(25, 91, 55, 15);
		contentPane.add(lblCpf);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(136, 83, 204, 24);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
	}

}
