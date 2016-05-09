package Shape;

import java.awt.*;

/**
 * Created by gui_h on 2016-05-06.
 */
public class Carre extends Forme {
    private Point p1,p2;
    private boolean isSquare;
    public Carre(Point p1, Point p2,boolean square){
        this.p1 = p1;
        this.p2 = p2;
        this.isSquare = square;
    }
    @Override
    public void paint(Graphics g) {
        if(isSquare) {
            double distance = Math.sqrt((p1.x-p2.x)*(p1.x-p2.x) + (p1.y-p2.y)*(p1.y-p2.y));//Calcul la distance de la diagonale entre les deux points
            int height = (int) Math.sqrt(distance * distance / 2);
            if(height == 0){//TODO Verifier si ok
                height = 1;
            }
            g.setColor(Color.red);
            g.fillRect (p1.x,p1.y,height,height);
        }
        else{
            int width = p2.x - p1.x;
            int height = p2.y - p1.y;
            g.setColor(Color.blue);
            g.fillRect (p1.x,p1.y,width,height);
        }
    }
}
