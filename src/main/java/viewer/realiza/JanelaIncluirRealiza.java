package viewer.realiza;

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

import controller.realiza.CtrlAbstratoRealiza;
import controller.realiza.CtrlIncluirRealiza;
import model.Cursa;
import model.Prova;
import viewer.JanelaAbstrata;

public class JanelaIncluirRealiza extends JanelaAbstrata {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField tfId;
	private JTextField tfNota;

	final private boolean 	habilitarProcura;
	private boolean    		realizaSelecionado;


	/**
	 * Create the frame.
	 */
	public JanelaIncluirRealiza(CtrlAbstratoRealiza ctrl, boolean habilitarProcura) {
		super(ctrl);
		this.realizaSelecionado = false;
		this.habilitarProcura = habilitarProcura;
		
		
		setTitle("Cadastrar Realiza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(24, 69, 55, 15);
		contentPane.add(lblId);
		
		JLabel lblNota = new JLabel("Nota");
		lblNota.setBounds(24, 100, 55, 15);
		contentPane.add(lblNota);
		
		JLabel lblIdCursa = new JLabel("ID Cursa");
		lblIdCursa.setBounds(24, 135, 55, 15);
		contentPane.add(lblIdCursa);
		
		JLabel lblIdProva = new JLabel("ID Prova");
		lblIdProva.setBounds(24, 173, 55, 15);
		contentPane.add(lblIdProva);
		
		tfId = new JTextField();
		tfId.setBounds(97, 67, 104, 19);
		contentPane.add(tfId);
		tfId.setColumns(10);
		
		tfNota = new JTextField();
		tfNota.setBounds(97, 98, 104, 19);
		contentPane.add(tfNota);
		tfNota.setColumns(10);
		
		JComboBox cbIdCursa = new JComboBox();
		cbIdCursa.setBounds(97, 130, 104, 24);
		contentPane.add(cbIdCursa);
		
		JComboBox cbIdProva = new JComboBox();
		cbIdProva.setBounds(97, 168, 104, 24);
		contentPane.add(cbIdProva);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int id;
				double nota;
				
				String aux = tfId.getText();
				try {
					id = Integer.parseInt(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Realiza inválido " + aux);
					return;
				}
				
				aux  = tfNota.getText();
				try {
					nota = Double.parseDouble(aux);
				} catch (NumberFormatException nfe) {
					JOptionPane.showMessageDialog(null, "Valor ID Realiza inválido " + aux);
					return;
				}
				
				
				CtrlIncluirRealiza ctrl = (CtrlIncluirRealiza)getCtrl();
				ctrl.efetuar(id, nota, (Set<Cursa>)cbIdCursa.getSelectedItem(), (Set<Prova>)cbIdProva.getSelectedItem());
			}
		});
		btnCadastrar.setBounds(190, 204, 98, 47);
		contentPane.add(btnCadastrar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					CtrlAbstratoRealiza ctrl = (CtrlAbstratoRealiza)getCtrl();
					ctrl.finalizar();	
			}
		});
		btnSair.setBounds(300, 204, 66, 47);
		contentPane.add(btnSair);
	}

}
