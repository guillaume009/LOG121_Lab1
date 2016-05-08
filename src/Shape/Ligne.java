package Shape;

import java.awt.*;

/**
 * Created by gui_h on 2016-05-08.
 */
public class Ligne extends Forme {
    private Point p1,p2;
    public Ligne(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
    }
    @Override
    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.drawLine (p1.x,p1.y,p2.x,p2.y);
    }
}
