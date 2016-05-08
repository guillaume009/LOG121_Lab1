package Shape;

import java.awt.*;

/**
 * Created by gui_h on 2016-05-06.
 */
public class Cercle extends Forme {
    private Point p;
    private int rayonH = 0;
    private int rayonW = 0;
    public Cercle(Point p, int rayon){
        this.p = p;
        this.rayonH = rayon;
    }
    public Cercle(Point p, int rayonH,int rayonW){
        this.p = p;
        this.rayonH = rayonH;
        this.rayonW = rayonW;
    }
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
