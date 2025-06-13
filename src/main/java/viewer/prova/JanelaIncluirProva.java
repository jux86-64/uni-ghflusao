package viewer.prova;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.prova.CtrlIncluirProva;
import controller.prova.CtrlAbstratoProva;
import model.Aluno;
import model.Turma;
import controller.prova.CtrlAbstratoProva;
import viewer.JanelaAbstrata;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Set;
import java.awt.event.ActionEvent;

public class JanelaIncluirProva extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfData;
	private JTextField tfPeso;
	
	final private boolean 	habilitarProcura;
	private boolean    		provaSelecionado;


	/**
	 * Create the frame.
	 */
	public JanelaIncluirProva(CtrlAbstratoProva ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.provaSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Prova");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(24, 51, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblData = new JLabel("Data");
		lblData.setBounds(24, 99, 55, 15);
		contentPane.add(lblData);
		
		JLabel lblIdTurma = new JLabel("ID Turma");
		lblIdTurma.setBounds(24, 148, 55, 15);
		contentPane.add(lblIdTurma);
		
		JLabel lblPeso = new JLabel("Peso");
		lblPeso.setBounds(24, 206, 55, 15);
		contentPane.add(lblPeso);
		
		tfId = new JTextField();
		tfId.setBounds(103, 49, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfData = new JTextField();
		tfData.setBounds(103, 97, 104, 19);
		contentPane.add(tfData);
		tfData.setColumns(10);
		
		tfPeso = new JTextField();
		tfPeso.setBounds(103, 204, 104, 19);
		contentPane.add(tfPeso);
		tfPeso.setColumns(10);
		
		JComboBox cbIdTurma = new JComboBox();
		cbIdTurma.setBounds(103, 143, 104, 24);
		contentPane.add(cbIdTurma);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				String data_p = tfData.getText();
				double peso;
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Prova inválido " + aux);
					return;
				}
				
				aux = tfPeso.getText();
				try {
					peso = Double.parseDouble(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor Peso Prova inválido " + aux);
					return;
				}
				
				
				CtrlIncluirProva ctrl = (CtrlIncluirProva)getCtrl();
				ctrl.efetuar(id, data_p, peso, (Set<Turma>)cbIdTurma.getSelectedItem());
			}
		});
		btnCadastrar.setBounds(210, 232, 126, 56);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CtrlAbstratoProva ctrl = (CtrlAbstratoProva)getCtrl();
					ctrl.finalizar();	
			}
		});
		btnSair.setBounds(342, 232, 68, 56);
		contentPane.add(btnSair);
	}

}
