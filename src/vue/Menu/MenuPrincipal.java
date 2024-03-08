package ProjetPatron.src.vue.Menu;

import ProjetPatron.src.controller.Bouton.menus.ButtonJouer;
import ProjetPatron.src.controller.Bouton.menus.ButtonParams;
import ProjetPatron.src.controller.Bouton.menus.ButtonRetour;
import ProjetPatron.src.vue.MainVue;

import javax.swing.*;

import static ProjetPatron.src.vue.MainVue.getPane;

public class MenuPrincipal extends MenuAbstract {

    private JPanel butPanel;

    public MenuPrincipal(MainVue mv){
        super(mv);
        butPanel = new JPanel();
        this.mv.setTitle("Menu principal");
        butPanel.setLayout(new BoxLayout(butPanel,BoxLayout.Y_AXIS));
        getPane().add(butPanel);
        butPanel.add(new ButtonJouer("Jouer"));
        butPanel.add(new ButtonParams("Paramètres"));
        butPanel.add(new ButtonRetour("Quitter"));
        this.repaint();
    }

    @Override
    public void repaint() {
        super.repaint();
    }


}
