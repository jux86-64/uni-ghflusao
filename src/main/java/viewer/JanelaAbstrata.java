package viewer;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controller.ICtrl;

public class JanelaAbstrata extends JFrame implements IViewer {
	
	// ATRIBUTOS DE RELACIONAMENTO
	final private ICtrl ctrl;
	
	public JanelaAbstrata(ICtrl c) {
		super();
		this.ctrl = c;
	}

	@Override
	public ICtrl getCtrl() {
		return this.ctrl;
	}

	@Override
	public void notificar(String textoDeNotificacao) {
		JOptionPane.showMessageDialog(null, textoDeNotificacao);
	}

	@Override
	public void finalizar() {
		this.setVisible(false);		
	}

	@Override
	public void apresentar() {
		this.setVisible(true);		
	}
}
