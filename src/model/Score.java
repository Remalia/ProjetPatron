package ProjetPatron.src.model;

import ProjetPatron.src.vue.Menu.GamePane;

import java.awt.*;

/***
 * Classe qui permet de gérer le score de la partie
 */
public class Score {
    private static Score instance;
    private int id;
    private float scoreMax;
    private float scoreAct;
    private float  scoreAffiche ;

    /***
     * Constructeur de la classe Score
     * @param id : id du score
     */
    private Score(int id){

        this.id = id;

        this.scoreMax = this.getScoreMax();
        this.scoreAct = this.getScoreAct();

        this.scoreAffiche = 0;
    }

    /***
     * Permet de récupérer le score maximum
     * @return le score max de la partie colorée
     */
    public float getScoreMax(){
        float size = GamePane.getInstance().getWidth() * GamePane.getInstance().getHeight();
        float red = 0;
        for(int i=0; i <GamePane.getInstance().getWidth(); i++){
            for(int j=0; j<GamePane.getInstance().getHeight();j++){
                Point point = new Point(i,j);
                if(GamePane.getColorAt(GamePane.getInstance(), point).equals(Color.RED)){
                    red+=1;
                }
            }
        }
        return size - red;
    }

    /***
     * Permet de récupérer le score actuel
     * @return le score actuel de la partie colorée
     */
    public float getScoreAct(){
        int size = GamePane.getInstance().getWidth() * GamePane.getInstance().getHeight();
        int green = 0;
        for(int i=0; i <GamePane.getInstance().getWidth(); i++){
            for(int j=0; j<GamePane.getInstance().getHeight();j++){
                Point point = new Point(i,j);
                if(GamePane.getColorAt(GamePane.getInstance(), point).equals(Color.GREEN)){
                    green+=1;
                }
            }
        }
        return size - green;
    }


    /***
     * Permet de calculer le score
     * @return le score actuel
     */
    public float calculScore(){
        this.scoreAct = this.getScoreAct();
        if(scoreAct != 0){
            this.scoreAffiche = this.scoreAct/this.scoreMax * 100;
        }

        return this.scoreAffiche;
    }

    /***
     * Permet de récupérer l'instance unique du score
     * @param id : id du score
     * @return l'instance du score
     */
    public static Score getInstance(int id){
        if (instance == null || instance.getId() != id){
            instance = new Score(id);
        }
        return instance;
    }

    /***
     * Permet de récupérer l'id du score
     * @return l'id du score
     */
    public int getId(){
        return id;
    }

}
