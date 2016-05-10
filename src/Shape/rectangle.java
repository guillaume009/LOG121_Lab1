package Shape;

import java.awt.*;

/**
 * Class qui permet de dessiner un carré ou un rectangle
 * Created by gui_h on 2016-05-06.
 */
public class rectangle extends Forme {
    private Point p1,p2;
    private boolean isSquare;

    /***
     * Constructeur de la classe
     * @param p1 les coordonnées du premier point
     * @param p2 les coordonnées du deuxième point
     * @param square Boolean en fonction de si c'est un carré
     */
    public rectangle(Point p1, Point p2, boolean square){
        this.p1 = p1;
        this.p2 = p2;
        this.isSquare = square;
    }

    /***
     * Dessine la forme en fonction des paramètres de la classe
     * @param g Permet de dessiner sur les composants
     */
    @Override
    public void paint(Graphics g) {
        int width = p2.x - p1.x;
        int height = p2.y - p1.y;
        if(isSquare) {
//            double distance = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));//Calcul la distance de la diagonale entre les deux points
//            int height = (int) Math.sqrt(distance * distance / 2);
            g.setColor(Color.red);
//            g.fillRect (p1.x,p1.y,height,height);
        }
        else{
            g.setColor(Color.blue);
        }
        g.fillRect (p1.x,p1.y,width,height);
    }
}
