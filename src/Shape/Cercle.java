package Shape;

import java.awt.*;

/**
 * Classe qui permet de dessiner des cercles ou des ovales en fonction des paramètres
 * Created by gui_h on 2016-05-06.
 */
public class Cercle extends Forme {
    private Point p;
    private int rayonH = 0;
    private int rayonW = 0;
    /***
     * Constructeur de la classe pour les cercles
     * @param p les coordonnées du point
     * @param rayon La grandeur du rayon du cercle
     */
    public Cercle(Point p, int rayon){
        this.p = p;
        this.rayonH = rayon;
    }
    /***
     * Constructeur de la classe pour les ovales
     * @param p les coordonnées du point
     * @param rayonH La grandeur du rayon vertical de l'ovale
     * @param rayonH La grandeur du rayon horizontal de l'ovale
     */
    public Cercle(Point p, int rayonH,int rayonW){
        this.p = p;
        this.rayonH = rayonH;
        this.rayonW = rayonW;
    }
    /***
     * Dessine la forme en fonction des paramètres de la classe
     * @param g Permet de dessiner sur les composants
     */
    @Override
    public void paint(Graphics g) {
        if(rayonW != 0){
            g.setColor(Color.magenta);
            g.fillOval(p.x,p.y, rayonW * 2, rayonH * 2);
        }
        else {
            g.setColor(Color.yellow);
            g.fillOval(p.x, p.y, rayonH * 2, rayonH * 2);
        }
    }
}
