package main.java.controller;

public interface ICtrl {
	public abstract ICtrl getCtrlPai();
	
	public abstract StatusExecucao getStatus();
	
	public abstract void finalizar();
	
	public abstract Object getBemTangivel();
	
	public abstract void ctrlFilhoFinalizado(ICtrl ctrlFilho);
}
