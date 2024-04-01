package ProjetPatron.src.model;

import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.vue.Menu.GamePane;

import java.awt.*;

/***
 * Classe qui permet de gérer le score de la partie
 */
public class Score {

    private float score;
    
    /***
     * Constructeur de la classe Score, initialise le score à 0
     */
    public Score(){
        this.score = 0;
    }

    /***
     * Permet de récupérer le score
     * @return le score de la partie colorée
     */
    public float getScore(){
        this.score = 0;
        for(Forme forme : MainModel.getInstance().getFormes()){
            this.score += forme.getAire();
        }
        return this.score /10000;
    }
  
    /***
     * Permet de calculer le score
     * @return le score actuel
     */
    public float calculScore(){
        this.score = this.getScore();
        return score;
    }

}
