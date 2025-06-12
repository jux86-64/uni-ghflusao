package viewer.aluno;



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

import controller.aluno.CtrlAbstratoAluno;
import controller.aluno.CtrlIncluirAluno;
import model.Turma;
import model.dao.DaoTurma;
import viewer.JanelaAbstrata;

public class JanelaIncluirAluno extends JanelaAbstrata {

	// COMPONENTES GRAFICOS
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfMatricula;
	private JTextField tfNome;
	private JTextField tfCpf;
	private JTextField tfTelefone;
	private JTextField tfEndereco;
	private JTextField tfIdade;
	private JComboBox cbIdTurma;
	private JButton	btnProcurarPorMatricula;
	private JButton	btnSair;
	private JButton	btnCadastrarAluno;
	
	final private boolean 	habilitarProcura;
	private boolean    		alunoSelecionado;

	/**
	 * Create the frame.
	 */
	public JanelaIncluirAluno(CtrlAbstratoAluno ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.alunoSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Aluno");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfId = new JTextField();
		tfId.setBounds(83, 50, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfMatricula = new JTextField();
		tfMatricula.setBounds(83, 81, 104, 19);
		contentPane.add(tfMatricula);
		tfMatricula.setColumns(10);
		
		JLabel lblId = new JLabel("Id Aluno");
		lblId.setBounds(16, 52, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblMatricula = new JLabel("Matricula");
		lblMatricula.setBounds(16, 83, 55, 15);
		contentPane.add(lblMatricula);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(16, 136, 55, 15);
		contentPane.add(lblNome);
		
		tfNome = new JTextField();
		tfNome.setBounds(83, 134, 248, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(83, 175, 164, 19);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(16, 177, 55, 15);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(16, 216, 55, 29);
		contentPane.add(lblTelefone);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(83, 221, 164, 19);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(16, 255, 55, 19);
		contentPane.add(lblEndereo);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(276, 177, 55, 15);
		contentPane.add(lblIdade);
		
		JLabel lblIdTurma = new JLabel("Id Turma");
		lblIdTurma.setBounds(244, 65, 55, 15);
		contentPane.add(lblIdTurma);
		
		cbIdTurma = new JComboBox(DaoTurma.obterIdTurmaTodos());
		cbIdTurma.setBounds(301, 60, 83, 24);
		contentPane.add(cbIdTurma); 
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(83, 255, 248, 19);
		contentPane.add(tfEndereco);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(315, 175, 104, 19);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id = Integer.parseInt(tfId.getText());
				int matricula = Integer.parseInt(tfMatricula.getText());
				String cpf = tfCpf.getText();
				String telefone = tfTelefone.getText();
				String endereco = tfEndereco.getText();
				int idade = Integer.parseInt(tfIdade.getText());
				String nome = tfNome.getText();
				
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(tfId.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Aluno inválido " + aux);
					return;
				}
				
				aux = tfMatricula.getText();
				try {
					matricula = Integer.parseInt(tfMatricula.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Matricula Aluno inválido " + aux);
					return;
				}
			
				try {
					cpf = tfCpf.getText();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor CPF Aluno inválido " + cpf);
					return;
				}
				
				try {
					telefone = tfTelefone.getText();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Telefone Aluno inválido " + telefone);
					return;
				}
				
				try {
					endereco = tfEndereco.getText();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Endereço Aluno inválido " + endereco);
					return;
				}
				
				aux = tfIdade.getText();
				try {
					idade = Integer.parseInt(tfIdade.getText());
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Telefone Aluno inválido " + aux);
					return;
				}
				
				try {
					nome = tfNome.getText();
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Nome Aluno inválido " + nome);
					return;
				}
				
				CtrlIncluirAluno ctrl = (CtrlIncluirAluno)getCtrl();
				ctrl.efetuar(id, matricula, cpf, telefone, endereco, idade, nome, (Turma)cbIdTurma.getSelectedItem());
			}
		});
		
		btnCadastrarAluno.setBounds(227, 299, 104, 45);
		contentPane.add(btnCadastrarAluno);
		
		btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoAluno ctrl = (CtrlAbstratoAluno)getCtrl();
				ctrl.finalizar();	
			}
		});
		btnSair.setBounds(340, 299, 98, 45);
		contentPane.add(btnSair);
		
		
		this.setVisible(true);
	}
	
	// ATUALIZAÇÃO DE DADOS 
	public void atualizarDados(int idAluno, int matricula, String cpf, String telefone, String endereco, int idade, String nome, Turma idTurma) {
		this.tfId.setText(Integer.toString(idAluno));
		this.tfMatricula.setText(Integer.toString(matricula));
		this.tfCpf.setText(cpf);
		this.tfTelefone.setText(telefone);
		this.tfEndereco.setText(endereco);
		this.tfIdade.setText(Integer.toString(idade));
		this.tfNome.setText(nome);
		this.cbIdTurma.setSelectedItem(idTurma);
		
		this.tfMatricula.setEnabled(false);
		if(this.habilitarProcura)
		 	this.btnProcurarPorMatricula.setEnabled(false);
		this.alunoSelecionado = true;
		
		/*this.cbIdTurma.addItem(idTurma);
		this.cbIdTurma.setSelectedItem(idTurma);*/
		
	}
}
