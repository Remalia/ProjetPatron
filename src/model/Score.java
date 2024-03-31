package ProjetPatron.src.model;

import ProjetPatron.src.model.Formes.Forme;
import ProjetPatron.src.vue.Menu.GamePane;

import java.awt.*;

public class Score {

    private float score;


    public Score(){


        this.score = 0;

    }


    public float getScore(){
        this.score = 0;
        for(Forme forme : MainModel.getInstance().getFormes()){
            this.score += forme.getAire();
        }
        return this.score /10000;
    }



    public float calculScore(){
        this.score = this.getScore();
        return score;
    }


}
