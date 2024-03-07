package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.MainVue;

public class MenuJeu extends MenuAbstract {


    public MenuJeu(MainVue mv){
        super(mv);
        this.mv.getBase().setTitle("Menu jeu");
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
