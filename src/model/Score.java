package ProjetPatron.src.model;

import ProjetPatron.src.vue.Menu.GamePane;

import java.awt.*;

public class Score {
    private static Score instance;
    private int id;
    private float scoreMax;
    private float scoreAct;
    private float  scoreAffiche ;

    private Score(int id){

        this.id = id;

        this.scoreMax = this.getScoreMax();
        this.scoreAct = this.getScoreAct();

        this.scoreAffiche = 0;
    }

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



    public float calculScore(){
        this.scoreAct = this.getScoreAct();
        if(scoreAct != 0){
            this.scoreAffiche = this.scoreAct/this.scoreMax * 100;
        }

        return this.scoreAffiche;
    }

    public static Score getInstance(int id){
        if (instance == null || instance.getId() != id){
            instance = new Score(id);
        }
        return instance;
    }

    public int getId(){
        return id;
    }

}
