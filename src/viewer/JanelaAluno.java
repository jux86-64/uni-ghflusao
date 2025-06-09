package viewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.CtrlIncluirAluno;
import model.Turma;
import javax.swing.JComboBox;

public class JanelaAluno extends JFrame {

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

	/**
	 * Create the frame.
	 */
	public JanelaAluno() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfId = new JTextField();
		tfId.setBounds(73, 50, 104, 19);
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
		tfNome.setBounds(73, 134, 248, 19);
		contentPane.add(tfNome);
		tfNome.setColumns(10);
		
		tfCpf = new JTextField();
		tfCpf.setBounds(73, 175, 164, 19);
		contentPane.add(tfCpf);
		tfCpf.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(16, 177, 55, 15);
		contentPane.add(lblCpf);
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setBounds(16, 211, 55, 29);
		contentPane.add(lblTelefone);
		
		tfTelefone = new JTextField();
		tfTelefone.setBounds(73, 216, 164, 19);
		contentPane.add(tfTelefone);
		tfTelefone.setColumns(10);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(16, 255, 55, 19);
		contentPane.add(lblEndereo);
		
		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(16, 294, 55, 15);
		contentPane.add(lblIdade);
		
		JLabel lblIdTurma = new JLabel("Id Turma");
		lblIdTurma.setBounds(244, 65, 55, 15);
		contentPane.add(lblIdTurma);
		
		cbIdTurma = new JComboBox(Turma.obterPeloIdTurma());
		cbIdTurma.setBounds(301, 60, 83, 24);
		contentPane.add(cbIdTurma);
		
		tfEndereco = new JTextField();
		tfEndereco.setColumns(10);
		tfEndereco.setBounds(83, 255, 248, 19);
		contentPane.add(tfEndereco);
		
		tfIdade = new JTextField();
		tfIdade.setBounds(56, 292, 104, 19);
		contentPane.add(tfIdade);
		tfIdade.setColumns(10);
		
		JButton btnCadastrarAluno = new JButton("Cadastrar");
		btnCadastrarAluno.setBounds(223, 341, 98, 25);
		contentPane.add(btnCadastrarAluno);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlIncluirAluno.finalizar();	
			}
		});
		btnSair.setBounds(333, 341, 98, 25);
		contentPane.add(btnSair);
		
		// TODO fazer o "habilitar busca" por MATRICULA
		
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
		
		/* this.tfMatricula.setEnabled(false);
		* if(this.habilitarProcura)
		* 	this.btConsultarPelaMatricula.setEnabled(false);
		* this.alunoSelecionado = true;
		*/
		
	}
}
