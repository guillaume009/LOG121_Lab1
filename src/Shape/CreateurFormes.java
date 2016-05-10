package Shape;

/**
 * Classe qui permet d'instancier une forme
 * Created by gui_h on 2016-05-06.
 */
public class CreateurFormes {
    public  CreateurFormes(){}

    /**
     * Crée une nouvelle forme. Cette méthode reçoit la chaîne de
     * caractères provenant du serveur de formes, elle détermine de quelle
     * forme il s'agit et applique l'opérateur new sur le constructeur de
     * la forme désirée.
     *
     * @param chaineForme un objet String contenant la chaîne de caractères
     *                    qui décrit une forme et provenant du serveur de
     *                    formes.
     *
     * @return une instance d'une des sous-classes de la classe abstraite
     *         Forme avec les paramètres passés par la chaîne d'entrée.
     */
    public Forme creerForme(String chaineForme,ShapeInfo s) {
        Forme f;
        if(chaineForme.equals("CERCLE")){
            f = new Cercle(s.getP1(),s.getRayon1());
        }
        else if(chaineForme.equals("OVALE")){
            f = new Cercle(s.getP1(),s.getRayon1(),s.getRayon2());
        }
        else if(chaineForme.equals("LIGNE")){
            f = new Ligne(s.getP1(),s.getP2());
        }
        else if(chaineForme.equals("CARRE")) {
            f = new Carre(s.getP1(), s.getP2(),true);
        }
        else{
            f = new Carre(s.getP1(), s.getP2(),false);
        }
        return f;
    }
}
