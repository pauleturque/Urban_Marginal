package outils.connexion;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class ServeurSocket extends Thread {



	private ServerSocket serverSocket ; 



	private AsyncResponse delegate = null; 
	

	public ServeurSocket(AsyncResponse delegate, int port) {
		// création du socket serveur d'écoute des clients
		try {
			this.delegate = delegate;
			this.serverSocket = new ServerSocket(port);
			System.out.println("Un client s'est connecté ");
			System.out.println("le serveur attend...");
			// le démarrage de l'�coute ne peut se faire que si un objet delegate existe (pour récupérer la r�ponse)
			if(delegate != null) {
				this.start();		
			}
		} catch (IOException e) {
			// problème grave qui ne devrait pas se produire : arrêt du programme
			System.out.println("erreur grave création socket serveur : " + e);
			System.exit(0);
		}
	}
	
	/**
	 * Méthode thread qui va attendre la connexion d'un client
	 */
	public void run() {
		// objet qui va récupérer le socket du client qui s'est connecté
		Socket socket ;
		// boucle infinie pour attendre un nouveau client
		while (true) {
			try {
				// attente d'une connexion
				System.out.println("le serveur attend");
				socket = serverSocket.accept();
				System.out.println("un client s'est connecté");
				// création d'une connexion vers ce client, pour la communication (envoi et réception d'informations)
				new Connection(socket, delegate);
			} catch (IOException e) {
				// problème grave qui ne devrait pas se produire : arrêt du programme
				System.out.println("erreur sur l'objet serverSocket : " + e);
				System.exit(0);
			}
		}
	}
	
}
