package viewer.turma;

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
import controller.turma.CtrlAbstratoTurma;
import controller.turma.CtrlIncluirTurma;
import model.Disciplina;
import model.dao.DaoDisciplina;
import model.enumerado.Situacao;
import model.enumerado.Turno;
import viewer.JanelaAbstrata;

public class JanelaIncluirTurma extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfData;
	private JComboBox cbTurno;
	private JComboBox cbSituacao;
	private JComboBox cbIdDisciplina;
	private JComboBox cbIdProfessor;
	
	final private boolean 	habilitarProcura;
	private boolean    		turmaSelecionado;


	/**
	 * Create the frame.
	 */
	public JanelaIncluirTurma(CtrlAbstratoTurma ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.turmaSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Turma");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfId = new JTextField();
		tfId.setBounds(142, 62, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		cbTurno = new JComboBox(Turno.obterTodos());
		cbTurno.setBounds(142, 93, 104, 24);
		contentPane.add(cbTurno);
		
		cbSituacao = new JComboBox(Situacao.obterTodos());
		cbSituacao.setBounds(142, 129, 104, 24);
		contentPane.add(cbSituacao);
		
		tfData = new JTextField();
		tfData.setBounds(142, 165, 104, 19);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		cbIdDisciplina = new JComboBox(DaoDisciplina.consultarDisciplinaTodos());
		cbIdDisciplina.setBounds(142, 196, 104, 24);
		contentPane.add(cbIdDisciplina);
		
		cbIdProfessor = new JComboBox();
		cbIdProfessor.setBounds(142, 232, 104, 24);
		contentPane.add(cbIdProfessor);
		
		JLabel lblIdTurma = new JLabel("ID Turma");
		lblIdTurma.setBounds(45, 64, 55, 15);
		contentPane.add(lblIdTurma);
		
		JLabel lblTurno = new JLabel("Turno");
		lblTurno.setBounds(45, 98, 55, 15);
		contentPane.add(lblTurno);
		
		JLabel lblSituação = new JLabel("Situação");
		lblSituação.setBounds(45, 134, 55, 15);
		contentPane.add(lblSituação);
		
		JLabel lblNewLabel = new JLabel("ID Professor");
		lblNewLabel.setBounds(45, 237, 72, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(45, 167, 55, 15);
		contentPane.add(lblData);
		
		JLabel lblIdDisciplina = new JLabel("ID Disciplina");
		lblIdDisciplina.setBounds(45, 201, 79, 15);
		contentPane.add(lblIdDisciplina);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				Turno turno = (Turno)cbTurno.getSelectedItem();
				Situacao situacao = (Situacao)cbSituacao.getSelectedItem();
				String data_t = tfData.getText();
				Disciplina idDisciplina = (Disciplina)cbIdDisciplina.getSelectedItem();
				Professor idProfessor = (Professor)cbIdProfessor.getSelectedItem();
				
				
				String aux = tfId.getText();
				try {
					id =Integer.parseInt(aux);
				} catch(NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "ID Inválido: " + aux);
					return;
				}
				
				CtrlIncluirTurma ctrl = (CtrlIncluirTurma)getCtrl();
				ctrl.efetuar(id, turno, situacao, data_t, idDisciplina, idProfessor);
				
			}
		});
		btnCadastrar.setBounds(258, 247, 98, 41);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CtrlAbstratoAluno ctrl = (CtrlAbstratoAluno)getCtrl();
				ctrl.finalizar();	
			}
		});
		btnSair.setBounds(366, 247, 72, 41);
		contentPane.add(btnSair);
		
		this.setVisible(true);
	}
	
	public void atualizarDados(int idTurma, Turno turno, Situacao situacao, String data_t,
								Disciplina idDisciplina, int idProfessor) {
		this.tfId.setText(Integer.toString(idTurma));
		this.cbTurno.setSelectedItem(turno);
		this.cbSituacao.setSelectedItem(situacao);
		this.cbIdDisciplina.setSelectedItem(idDisciplina);
		this.cbIdProfessor.setSelectedItem(idProfessor);
		
	}
}
