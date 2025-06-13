package viewer.cursa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controller.cursa.CtrlAbstratoCursa;
import controller.cursa.CtrlIncluirCursa;
import model.Aluno;
import model.Turma;
import viewer.JanelaAbstrata;

public class JanelaIncluirCursa extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfData;
	private JComboBox cbIdAluno;
	private JComboBox cbIdTurma;
	
	final private boolean 	habilitarProcura;
	private boolean    		cursaSelecionado;


	/**
	 * Create the frame.
	 */
	public JanelaIncluirCursa(CtrlAbstratoCursa ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.cursaSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Cursa");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(41, 67, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(41, 102, 55, 15);
		contentPane.add(lblData);
		
		JLabel lblIdAluno = new JLabel("ID Aluno");
		lblIdAluno.setBounds(41, 142, 55, 15);
		contentPane.add(lblIdAluno);
		
		JLabel lblIdTurma = new JLabel("ID Turma");
		lblIdTurma.setBounds(41, 181, 55, 15);
		contentPane.add(lblIdTurma);
		
		tfId = new JTextField();
		tfId.setBounds(124, 65, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfData = new JTextField();
		tfData.setBounds(124, 100, 104, 19);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		cbIdAluno = new JComboBox();
		cbIdAluno.setBounds(124, 137, 104, 24);
		contentPane.add(cbIdAluno);
		
		cbIdTurma = new JComboBox();
		cbIdTurma.setBounds(124, 176, 104, 24);
		contentPane.add(cbIdTurma);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String data_c = tfData.getText();
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Cursa inválido " + aux);
					return;
				}
				
				
				CtrlIncluirCursa ctrl = (CtrlIncluirCursa)getCtrl();
				ctrl.efetuar(id, data_c, (Set<Aluno>)cbIdAluno.getSelectedItem(), (Set<Turma>)cbIdTurma.getSelectedItem());
			}
		});
		btnCadastrar.setBounds(193, 238, 98, 50);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CtrlAbstratoCursa ctrl = (CtrlAbstratoCursa)getCtrl();
					ctrl.finalizar();	
			}
		});
		btnSair.setBounds(298, 238, 71, 50);
		contentPane.add(btnSair);
	}
	
	// ATUALIZAÇÃO DE DADOS 
	public void atualizarIdTurma(Turma nova) {
		this.cbIdTurma.addItem(nova);
		this.cbIdTurma.setSelectedItem(nova);
	}
	
	public void atualizarIdAluno(Aluno novo) {
		this.cbIdAluno.addItem(novo);
		this.cbIdAluno.setSelectedItem(novo);
	}

}
