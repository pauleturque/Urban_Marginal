package controleur;

import Vue.start_window;


public class Controle {

	private Vue.start_window frmEntreeJeu ;

	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Constructeur
	 */
	private Controle() {
		this.frmEntreeJeu = new start_window() ;
		this.frmEntreeJeu.setVisible(true);
	}
	

}
