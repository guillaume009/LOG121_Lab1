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

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JComponent;

/**
 * Cette fenêtre gère l'affichage des formes 
 * @author Patrice Boucher
 * @date 2013/05/04
 */
public class FenetreFormes extends JComponent{
	
	private static final long serialVersionUID = -2262235643903749505L;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 500;
	public static final Dimension dimension = new Dimension(WIDTH,HEIGHT);
	public Forme[] arf = new Forme[10];
		
	/**
	 * Constructeur
	 */
	public FenetreFormes(){
	}

	/***
	 * Passe au travers du tableau des formes et affiche chacun d'eux
	 * @param g Permet de dessiner les formes
     */
	@Override 
	public void paint(Graphics g){
		for(Forme f : arf){
			if(f != null) {
				f.paint(g);
			}
		}
	}

	/***
	 * Ajoute une forme à la liste de forme et supprime la plus vieille s'il y en a déjà 10
	 * @param f La forme à ajouter
     */
	public void addFormeToList(Forme f){
		boolean added = false;
		for(int i = 0; i < arf.length; i++){
			if(arf[i] == null){
				arf[i] = f;
				added = true;
				break;
			}
		}
		if(!added){//Le array est plein il faut donc enlever le premier pour faire de la place pour le nouveau
			for(int i = 0; i < arf.length - 1; i++){
				if(arf[i + 1] != null){
					arf[i] = arf[i + 1];
				}
			}
			arf[9] = f;
		}
	}
	
	/*
	 * Le Layout qui utilise (contient) FenetreFormes doit réserver 
	 * l'espace nécessaire à son affichage
	 */
	@Override 
	public Dimension getPreferredSize(){
		return dimension;
	}
}
