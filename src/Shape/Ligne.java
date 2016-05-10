package Shape;

import java.awt.*;

/**
 * Created by gui_h on 2016-05-08.
 */
public class Ligne extends Forme {
    private Point p1,p2;
    /***
     * Constructeur de la classe
     * @param p1 les coordonnées du premier point
     * @param p2 les coordonnées du deuxième point
     */
    public Ligne(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    /***
     * Dessine la forme en fonction des paramètres de la classe
     * @param g Permet de dessiner sur les composants
     */
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.drawLine (p1.x,p1.y,p2.x,p2.y);
    }
}
