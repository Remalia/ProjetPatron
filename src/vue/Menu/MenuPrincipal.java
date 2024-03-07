package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.vue.MainVue;

import javax.swing.*;

public class MenuPrincipal extends MenuAbstract {

    public MenuPrincipal(MainVue mv){
        super(mv);
        this.setLayout(new BoxLayout(this,BoxLayout.PAGE_AXIS));
        this.mv.getBase().setTitle("Menu principal");
        JButton butJouer = new JButton("Jouer");
        this.add(butJouer);
        this.repaint();
    }

    @Override
    public void repaint() {
        super.repaint();
    }
}
