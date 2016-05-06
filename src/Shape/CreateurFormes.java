package Shape;

/**
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
    public Forme creerForme(String chaineForme) {
        Forme f;
        if(chaineForme.equals("CERCLE")){
            f = new Cercle();
        }
        else if(chaineForme.equals("OVALE")){
            f = new Ovale();
        }
        else{
            f = new Carre();
        }
        return f;
    }
}
