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
	public CommBase(){
	}
	
	/**
	 * D�finir le r�cepteur de l'information re�ue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
//	public void connectToServer(){
//		try {
//			s = new Socket(serverName, serverPort); TODO remettre
//			s = new Socket("localhost", 10000);
//		} catch (IOException e) {
//			System.out.println("Une erreur est survenue à la communication avec le serveur");
//		}
//	}
//	public void disconnectFromServer(){
//		try {
//			s.close();
//		} catch (IOException e) {
//			System.out.println("Une erreur est survenue à lors de la fermeture de la connexion avec le serveur");
//		}
//	}
	/**
	 * Démarre la communication
	 */
	public void start(){
		try {
			s = new Socket("localhost", 10000);
			logger = IDLogger.getInstance();
		} catch (IOException e) {
			System.out.println("Une erreur est survenue à la communication avec le serveur");
		}
		shapeInfo = new ShapeInfo();
		logger = IDLogger.getInstance();
		creerCommunication();
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
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication(){		
		// Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");
				while(true){
		            out = new PrintWriter(s.getOutputStream(), true);
		            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			        out.println("GET");

					Forme f = shapeInfo.extractServerResponse(in.readLine());
					if(f != null) {
						logger.logID(shapeInfo.getNoSeq());
					}
					Thread.sleep(DELAI);
 					//La méthode suivante alerte l'observateur
					if(listener!=null)
					   firePropertyChange("newForme", null, f);
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
