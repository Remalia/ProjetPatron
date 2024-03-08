package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.MainVue;

import javax.swing.*;

public class MenuPrincipal extends MenuAbstract {

    public MenuPrincipal(MainVue mv){
        super(mv);
        this.mv.setTitle("Menu principal");
        JButton butJouer = new JButton("Jouer");
        JButton butParam = new JButton("Param");
        JButton butQuitter = new JButton("Quitter");
        this.mv.getButPanel().add(butJouer);
        this.mv.getButPanel().add(butParam);
        this.mv.getButPanel().add(butQuitter);
        this.repaint();
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
