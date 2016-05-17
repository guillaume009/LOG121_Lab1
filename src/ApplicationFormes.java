/******************************************************
 Cours:  LOG121
 Projet: Squelette du laboratoire #1
 Nom du fichier: CommBase.java
 Date créé: 2013-05-03
 *******************************************************
 Historique des modifications
 *******************************************************
 *@author Patrice Boucher
2013-05-03 Version initiale
 *******************************************************
 *@author Guillaume Boudreau
2016-05-05 Ajout des fonctions pour le labo 1
 *******************************************************/


import javax.swing.JOptionPane;

/**
 * Cette classe représente l'application dans son ensemble. 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class ApplicationFormes{
	
	/**
	 * main de l'application
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationFormes application = new ApplicationFormes();
	}
	
	/**
	 * Constructeur
	 * Affiche une boite de dialogue pour que l'utilisateur puisse choisir le serveur et le port
	 * Sépare ensuite le serveur et le port pour les mettre dans des variables pour l'utilisateur par après
	 */
	public ApplicationFormes(){
		CommBase comm = new CommBase();
		String serverName = JOptionPane.showInputDialog(null, "Quel est le nom d'hôte et le port du serveur de formes?");
		if(serverName != null){
			String[] parts = serverName.split(":");
			if(parts.length == 2) {
				comm.serverName = parts[0];
				comm.serverPort = Integer.parseInt(parts[1]);
				FenetrePrincipale fenetre = new FenetrePrincipale(comm);
				comm.setPropertyChangeListener(fenetre);
			}
		}
	}
}
