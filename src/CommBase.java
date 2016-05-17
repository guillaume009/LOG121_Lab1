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

import Shape.Forme;
import Shape.ShapeInfo;
import ca.etsmtl.log.util.IDLogger;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.SwingWorker;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	
	public static String serverName = "";
	public static int serverPort = 0;
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
	private Socket s;
	private PrintWriter out;
	private BufferedReader in;
	private ShapeInfo shapeInfo;
	private IDLogger logger;

	/**
	 * Constructeur
	 */
	public CommBase(){}
	
	/**
	 * Définir le récepteur de l'information reçue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	/**
	 * Démarre la communication et instancie les différents éléments nécessaire
	 */
	public void start(){
		try {
			s = new Socket(serverName, serverPort);
			logger = IDLogger.getInstance();
			out = new PrintWriter(s.getOutputStream(), true);
			shapeInfo = new ShapeInfo();
			logger = IDLogger.getInstance();
			gererCommunication();
		} catch (IOException e) {
			System.out.println("Une erreur est survenue à la communication avec le serveur");
		}
	}
	
	/**
	 * Arrête la communication
	 */
	public void stop(){
		if(threadComm!=null){
			threadComm.cancel(true); 
			try {
				out.println("END");
				out.close();
		        in.close();
				s.close();
	        } catch (IOException e) {
				System.out.println("Une erreur est survenue à lors de la fermeture de la connexion avec le serveur");
	        }
		}
		isActif = false;
	}
	
	/**
	 * Créer le nécessaire pour la communication avec le serveur et reçoit les chaines de caratères de celui-ci
	 * Ajoute également le numéro de séquence au log
	 */
	protected void gererCommunication(){
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				while(true){
					in = new BufferedReader(new InputStreamReader(s.getInputStream()));
					out.println("GET");
					Forme f = shapeInfo.extractServerResponse(in.readLine());
					if(f != null) {
						if(listener!=null) {//Alerte l'observateur
							firePropertyChange("newForme", null, f);
							logger.logID(shapeInfo.getNoSeq());
						}
					}
					Thread.sleep(DELAI);
				}
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger"
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}
	
	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
