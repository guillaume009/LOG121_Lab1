package Shape;

import javax.swing.*;
import java.awt.*;

/**
 * Classe abstraite pour la base de toutes les formes
 * Created by gui_h on 2016-05-06.
 */
public abstract class Forme extends JComponent {
    /***
     * Méthode pour le dessin de la forme
     */
    @Override
    public abstract void paint(Graphics g);
}
