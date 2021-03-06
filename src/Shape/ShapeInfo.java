package Shape;

import java.awt.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe qui gére la chaine du serveur et la transforme en informations sur la forme
 * Created by gui_h on 2016-05-05.
 */
public class ShapeInfo {
    private Pattern p = Pattern.compile("([0-9]+) <(.*)>(.*)</(.*)>");
    private String shapeType = "";
    private Point p1 = null;
    private Point p2 = null;
    private int rayon1 = 0;
    private int rayon2 = 0;
    private String noSeq = "";

    public ShapeInfo(){}

    /***
     * Sépare la chaine de caractères que le serveur envoit et sépare les différentes informations.
     * Une forme est ensuite créer avec les données du serveur
     * @param serverResponse
     * @return Retourne la forme correspondante aux données de la chaine en paramètre
     */
    public Forme extractServerResponse(String serverResponse){
        Matcher m = p.matcher(serverResponse);
        CreateurFormes createurFormes = new CreateurFormes();
        Forme f = null;
        while (m.find()) {
            noSeq = m.group(1);
            shapeType = m.group(2);
            String[] parts = m.group(3).trim().split(" ");
            p1 = new Point(Integer.parseInt(parts[0]),Integer.parseInt(parts[1]));
            if(shapeType.equals("CERCLE")){
                rayon1 = Integer.parseInt(parts[2]);
            }
            else if(shapeType.equals("OVALE")){
                rayon1 = Integer.parseInt(parts[2]);
                rayon2 = Integer.parseInt(parts[3]);
            }
            else{
                p2 = new Point(Integer.parseInt(parts[2]),Integer.parseInt(parts[3]));
            }
            f = createurFormes.creerForme(this);
        }
        return f;
    }

    public String getShapeType() {
        return shapeType;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public int getRayon1() {
        return rayon1;
    }

    public int getRayon2() {
        return rayon2;
    }

    public int getNoSeq() {
        return Integer.parseInt(noSeq);
    }
}
