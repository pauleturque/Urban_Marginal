package controleur;

import Vue.ChoiceWindow;
import outils.connexion.AsyncResponse;
import outils.connexion.ClientSocket;
import outils.connexion.Connection;
import outils.connexion.ServeurSocket;

import java.awt.desktop.AppEvent;
import java.io.IOException;
import java.net.ServerSocket;

import javax.swing.ImageIcon;

import Vue.Arene;

public class Controle implements AsyncResponse{

	private static final int PORT = 6666;
	private Vue.EntreeJeu frmEntreeJeu ;
	private Vue.Arene arene;
	private Vue.ChoiceWindow choiceWindow;
	private String typeJeu;

	public static void main(String[] args) {
		new Controle();
	}
	
	/**
	 * Constructor
	 */
	private Controle() {
		this.frmEntreeJeu = new Vue.EntreeJeu(this) ;
		this.frmEntreeJeu.setVisible(true);
		try {
			ServerSocket serveurSocket = new ServerSocket(PORT);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void evenementEntreeJeu(String info) {
		if(info == "Start") {
			//this.typeJeu = "serveur";
			this.arene = new Arene();
			this.arene.setVisible(true);
			this.frmEntreeJeu.setVisible(false);
			System.out.println("Le serveur attend...");
		}
		if(info == "Connect") {
			this.choiceWindow = new ChoiceWindow(this);
			this.choiceWindow.setVisible(true);
			this.frmEntreeJeu.setVisible(false);
		}
		if(info == "Exit") {
			System.exit(0);
		}
	}

	

	@Override
	public void reception(Connection connection, String ordre, Object info) {
		// TODO Auto-generated method stub
		
	}

	public void evenementChoiceWindow(String text, int numPerso) {
		this.choiceWindow.dispose();
		this.arene.setVisible(true);
		
	}
	
	
	

}
