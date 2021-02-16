import java.net.InetAddress;
import java.net.UnknownHostException;


/**
 * Gestion du jeu c�t� client
 *
 */

public class JeuClient extends Jeu {
	
	public static void main(String[] args) {
		try {
			InetAddress adresseLocale = InetAddress.getLocalHost();
			System.out.println(adresseLocale);
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	/**
	 * Controleur
	 */
	public JeuClient() {
	}
	
	@Override
	public void connexion() {
	}

	@Override
	public void reception() {
	}
	
	@Override
	public void deconnexion() {
	}

	/**
	 * Envoi d'une information vers le serveur
	 * fais appel une fois � l'envoi dans la classe Jeu
	 */
	public void envoi() {
	}

}
