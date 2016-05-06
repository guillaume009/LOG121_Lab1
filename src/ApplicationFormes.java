/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: ApplicationFormes.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  
 

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

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
	 */
	public ApplicationFormes(){
		CommBase comm = new CommBase();
		String serverName = JOptionPane.showInputDialog(null, "Quel est le nom d'hôte et le port du serveur de formes?");
		if(serverName != null){
//			String[] parts = serverName.split(":");
//			comm.serverName = parts[0];
//			comm.serverPort = Integer.parseInt(parts[1]);
//			comm.connectToServer();
			FenetrePrincipale fenetre = new FenetrePrincipale(comm);	
			comm.setPropertyChangeListener(fenetre);
		}
	}
}
