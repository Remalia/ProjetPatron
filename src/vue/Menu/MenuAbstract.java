package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.MainVue;

import javax.swing.*;

public abstract class MenuAbstract extends JPanel{

    MainVue mv;

    public MenuAbstract(MainVue mv){
        this.mv = mv;
    }
}
