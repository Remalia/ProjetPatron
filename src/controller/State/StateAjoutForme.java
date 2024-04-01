package ProjetPatron.src.controller.State;

import ProjetPatron.src.model.Formes.Coord;

import java.util.ArrayList;
import java.util.List;

/***
 * Classe abstraite d'ajout de forme
 */
public abstract class StateAjoutForme implements State{
    private List<Coord> posClicks;

    /***
     * Constructeur de la classe
     */
    protected StateAjoutForme(){
        this.posClicks = new ArrayList<>();
    }

    /***
     * Méthode qui retourne la liste des coordonnées des clics
     * @return posClicks : Liste des coordonnées des clics
     */
    public List<Coord> getPosClicks() {
        return posClicks;
    }

    /***
     * Méthode qui modifie la liste des coordonnées des clics
     * @param posClicks
     */
    public void setPosClicks(List<Coord> posClicks) {
        this.posClicks = posClicks;
    }
}
